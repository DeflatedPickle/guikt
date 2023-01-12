/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <T : Number> ContainerBuilder<*>.spinner(
    constraint: Constraint,
    block: SpinnerBuilder<T>.() -> Unit = {}
) = SpinnerBuilder<T>(constraint).apply(block).build().apply { components[this] = constraint }

interface Spinner<T : Number> : Component<Constraint> {
    val constraint: Constraint

    val model: Model.Spinner.Number<T>
}

@GuiDSL
class SpinnerBuilder<T : Number>(
    var constraint: Constraint
) : WidgetBuilder<Spinner<T>>() {
    var enabled = true
    var model = Model.Spinner.Number<T>()

    override fun build() = GuiKT.backend.registry[Spinner::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, model,
    ) as Spinner<T>
}