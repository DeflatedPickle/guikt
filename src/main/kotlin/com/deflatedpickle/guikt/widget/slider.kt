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

fun <C : Constraint> ContainerBuilder<*>.slider(
    constraint: C,
    block: SliderBuilder<C>.() -> Unit = {}
) = SliderBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface Slider<C : Constraint> : Component<C> {
    val constraint: C

    val _orientation: Orientation
    val model: Model.BoundedRange.Integer
}

@GuiDSL
class SliderBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<Slider<C>>() {
    var enabled = true
    var orientation = Orientation.HORIZONTAL
    var model = Model.BoundedRange.Integer(
        value = 0,
        extent = 0,
        min = 0,
        max = 100,
    )

    override fun build() = GuiKT.backend.registry[Slider::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, orientation, model,
    ) as Slider<C>
}