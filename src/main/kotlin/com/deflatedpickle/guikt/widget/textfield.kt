/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <C : Constraint> ContainerBuilder<*>.textfield(
    constraint: C,
    block: TextFieldBuilder<C>.() -> Unit = {}
) = TextFieldBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface TextField<C : Constraint> : Component<C> {
    val constraint: C

    val _text: String
    val _columns: Int
}

@GuiDSL
class TextFieldBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<TextField<C>>() {
    var enabled = true

    var text: String = ""
    var columns: Int = 0

    override fun build() = GuiKT.backend.registry[TextField::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, text, columns,
    ) as TextField<C>
}