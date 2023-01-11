/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <C : Constraint> ContainerBuilder<*>.slider(
    constraint: C,
    block: SliderBuilder<C>.() -> Unit = {}
) = SliderBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface Slider<C : Constraint> : Component<C> {
    val constraint: C

    val _orientation: Orientation
    val min: Int
    val max: Int
    val _value: Int
}

@GuiDSL
class SliderBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<Slider<C>>() {
    var orientation = Orientation.HORIZONTAL
    var min = 0
    var max = 100
    var value = 50

    override fun build() = GuiKT.backend.registry[Slider::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, orientation, min, max, value,
    ) as Slider<C>
}