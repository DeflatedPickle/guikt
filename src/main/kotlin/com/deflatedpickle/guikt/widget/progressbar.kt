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

fun <C : Constraint> ContainerBuilder<*>.progressbar(
    constraint: C,
    block: ProgressBarBuilder<C>.() -> Unit = {}
) = ProgressBarBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface ProgressBar<C : Constraint> : Component<C> {
    val constraint: C

    val _orientation: Orientation
    val min: Int
    val max: Int
    val _value: Int
}

@GuiDSL
class ProgressBarBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<ProgressBar<C>>() {
    var enabled = true

    var orientation = Orientation.HORIZONTAL
    var min = 0
    var max = 100
    var value = 0

    override fun build() = GuiKT.backend.registry[ProgressBar::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, orientation, min, max, value,
    ) as ProgressBar<C>
}