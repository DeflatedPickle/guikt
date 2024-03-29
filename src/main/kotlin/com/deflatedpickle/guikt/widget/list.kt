/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <T : Any> ContainerBuilder<*>.list(
    constraint: Constraint,
    block: ListBuilder<T>.() -> Unit = {}
) = ListBuilder<T>(constraint).apply(block).build().apply { components[this] = constraint }

interface List<T : Any> : Component<Constraint> {
    val constraint: Constraint

    val model: Model.List.Default<T>
    val index: Int

    val onSelection: MutableList<Listener>
}

@GuiDSL
class ListBuilder<T : Any>(
    var constraint: Constraint
) : WidgetBuilder<List<T>>() {
    var enabled = true

    var model = Model.List.Default<T>()
    var index = 0

    var onSelection: MutableList<Listener> = mutableListOf()

    override fun build() = GuiKT.backend.registry[List::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, model, index, onSelection,
    ) as List<T>
}