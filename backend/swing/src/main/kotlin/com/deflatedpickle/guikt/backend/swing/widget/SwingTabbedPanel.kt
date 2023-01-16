package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.TabbedPanel
import com.deflatedpickle.guikt.widget.TabbedPanelBuilder
import java.awt.Component
import javax.swing.ImageIcon
import javax.swing.JTabbedPane

class SwingTabbedPanel<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val tabs: List<TabbedPanel.Tab>,
) : TabbedPanel<C>, JTabbedPane() {
    init {
        isEnabled = enabled

        for (i in tabs) {
            addTab(
                i.title,
                if (i.icon == null) null else ImageIcon(i.icon!!.name, i.icon!!.description),
                i.component as Component,
                i.tip,
            )
        }
    }
}