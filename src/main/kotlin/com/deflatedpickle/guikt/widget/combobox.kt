/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Icon
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <T : Any> ContainerBuilder<*>.combobox(
    constraint: Constraint,
    block: ComboBoxBuilder<T>.() -> Unit = {}
) = ComboBoxBuilder<T>(constraint).apply(block).build().apply { components[this] = constraint }

interface ComboBox<T : Any> : Component<Constraint> {
    val constraint: Constraint

    val enabled: Boolean

    val editable: Boolean
    val items: MutableList<T>
    val index: Int

    val onItem: MutableList<Listener>
    val onClick: MutableList<Listener>
}

@GuiDSL
class ComboBoxBuilder<T : Any>(
    var constraint: Constraint
) : WidgetBuilder<ComboBox<T>>() {
    var enabled = true

    var editable = false
    var items: MutableList<T> = mutableListOf()
    var index = 0

    var onItem: MutableList<Listener> = mutableListOf()
    var onClick: MutableList<Listener> = mutableListOf()

    override fun build() = GuiKT.backend.registry[ComboBox::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, editable, items, index, onItem, onClick,
    ) as ComboBox<T>
}