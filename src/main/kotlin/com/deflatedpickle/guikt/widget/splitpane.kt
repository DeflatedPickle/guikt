package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.Container
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Layout


fun <C : Constraint> ContainerBuilder<*>.splitpane(
    constraint: C,
    block: SplitPaneBuilder<C>.() -> Unit = {}
) = SplitPaneBuilder(constraint).apply(block).build().apply { this@splitpane.components[this] = constraint }

interface SplitPane<C : Constraint> : Component<C> {
    val constraint: C

    val left: Component<out Constraint>
    val right: Component<out Constraint>
    val orientation: Orientation
    val continuous: Boolean
    val touchExpand: Boolean
}

@GuiDSL
class SplitPaneBuilder<C : Constraint>(
    var constraint: C,
) : ContainerBuilder<SplitPane<C>>() {
    var left: Component<out Constraint>? = null
    var right: Component<out Constraint>? = null
    var orientation = Orientation.HORIZONTAL
    var continuous = true
    var touchExpand = false

    override fun build() = GuiKT.backend.registry[SplitPane::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, left, right, orientation, continuous, touchExpand,
    ) as SplitPane<C>
}