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

fun <C : Constraint> ContainerBuilder<*>.textarea(
    constraint: C,
    block: TextAreaBuilder<C>.() -> Unit = {}
) = TextAreaBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface TextArea<C : Constraint> : Component<C> {
    val constraint: C

    val _text: String
    val _rows: Int
    val _columns: Int
    val wrap: Boolean
}

@GuiDSL
class TextAreaBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<TextArea<C>>() {
    var text = ""
    var rows = 0
    var columns = 0
    var wrap = false

    override fun build() = GuiKT.backend.registry[TextArea::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, text, rows, columns, wrap,
    ) as TextArea<C>
}