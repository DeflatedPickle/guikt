package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Container
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Layout


fun <C : Constraint, T : Layout> ContainerBuilder<*>.panel(
    constraint: C,
    layout: T,
    block: PanelBuilder<C, T>.() -> Unit = {}
) = PanelBuilder(constraint, layout).apply(block).build().apply { this@panel.components[this] = constraint }

interface Panel<C : Constraint, T : Layout> : Container<T, C> {
    val constraint: C
    val layout: T
    val components: ComponentMap
}

@GuiDSL
class PanelBuilder<C : Constraint, T : Layout>(
    var constraint: C,
    var layout: T,
) : ContainerBuilder<Panel<C, T>>() {
    override fun build() = GuiKT.backend.registry[Panel::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, layout, true, components,
    ) as Panel<C, T>
}