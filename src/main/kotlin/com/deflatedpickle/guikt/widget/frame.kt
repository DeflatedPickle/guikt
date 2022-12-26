/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.api.Container
import com.deflatedpickle.guikt.api.Dimension
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.x
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Layout

fun <T : Layout> frame(
    layout: T,
    block: FrameBuilder<T>.() -> Unit = {}
) = FrameBuilder(layout).apply(block).build()

interface Frame<T : Layout> : Container<T, Constraint> {
    val layout: T
    val _title: String
    val _size: Dimension
    val closeOperation: CloseOperation
    val components: ComponentMap
}

@GuiDSL
class FrameBuilder<T : Layout>(
    var layout: T
) : ContainerBuilder<Frame<T>>() {
    var title: String = ""
    var size: Dimension = 420 x 360
    var closeOperation: CloseOperation = CloseOperation.EXIT

    override fun build() = GuiKT.backend.registry[Frame::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        layout, title, size, closeOperation, components,
    ) as Frame<T>
}