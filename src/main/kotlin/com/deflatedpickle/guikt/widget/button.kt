/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <C : Constraint> ContainerBuilder<*>.button(
    constraint: C,
    block: ButtonBuilder<C>.() -> Unit = {}
) = ButtonBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface Button<C : Constraint> : Component<C> {
    val constraint: C
    val _text: String
}

@GuiDSL
class ButtonBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<Button<C>>() {
    var text: String = ""

    override fun build() = GuiKT.backend.registry[Button::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, text,
    ) as Button<C>
}