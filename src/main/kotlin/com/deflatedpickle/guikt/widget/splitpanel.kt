package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder


fun <C : Constraint> ContainerBuilder<*>.splitpanel(
    constraint: C,
    block: SplitPanelBuilder<C>.() -> Unit = {}
) = SplitPanelBuilder(constraint).apply(block).build().apply { this@splitpanel.components[this] = constraint }

interface SplitPanel<C : Constraint> : Component<C> {
    val constraint: C

    val left: Component<out Constraint>
    val right: Component<out Constraint>
    val orientation: Orientation
    val continuous: Boolean
    val touchExpand: Boolean
}

@GuiDSL
class SplitPanelBuilder<C : Constraint>(
    var constraint: C,
) : ContainerBuilder<SplitPanel<C>>() {
    var left: Component<out Constraint>? = null
    var right: Component<out Constraint>? = null
    var orientation = Orientation.HORIZONTAL
    var continuous = true
    var touchExpand = false

    override fun build() = GuiKT.backend.registry[SplitPanel::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, true, left, right, orientation, continuous, touchExpand,
    ) as SplitPanel<C>
}