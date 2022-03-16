/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.api.Container
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.LayoutManager

fun <T : LayoutManager> frame(
    layout: T,
    block: FrameBuilder<T>.() -> Unit = {}
) = FrameBuilder(layout).apply(block).build()

abstract class Frame<T : LayoutManager>(
    val layout: T,
    val title: String,
    val width: Int,
    val height: Int,
    val closeOperation: CloseOperation,
    val componentList: ComponentMap
) : Container<T, Constraint>()

@GuiDSL
class FrameBuilder<T : LayoutManager>(
    var layout: T
) : ContainerBuilder<Frame<*>, Constraint>() {
    var title: String = ""
    var width: Int = 420
    var height: Int = 360
    var closeOperation: CloseOperation = CloseOperation.EXIT

    override fun build() = GuiKT.backend.registry[Frame::class]?.constructors?.first()?.call(
        layout, title, width, height, closeOperation, components,
    ) as Frame<T>
}