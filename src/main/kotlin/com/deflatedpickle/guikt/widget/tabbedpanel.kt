package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Icon
import com.deflatedpickle.guikt.widget.TabbedPanel.Tab
import kotlin.collections.List


fun <C : Constraint> ContainerBuilder<*>.tabbedpanel(
    constraint: C,
    block: TabbedPanelBuilder<C>.() -> Unit = {}
) = TabbedPanelBuilder(constraint).apply(block).build().apply { this@tabbedpanel.components[this] = constraint }

interface TabbedPanel<C : Constraint> : Component<C> {
    data class Tab (
        val title: String = "",
        val icon: Icon? = null,
        val component: Component<out Constraint>,
        val tip: String? = null,
    )

    val constraint: C

    val tabs: List<Tab>
}

@GuiDSL
class TabbedPanelBuilder<C : Constraint>(
    var constraint: C,
) : ContainerBuilder<TabbedPanel<C>>() {
    var tabs = mutableListOf<Tab>()

    override fun build() = GuiKT.backend.registry[TabbedPanel::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, true, tabs,
    ) as TabbedPanel<C>
}