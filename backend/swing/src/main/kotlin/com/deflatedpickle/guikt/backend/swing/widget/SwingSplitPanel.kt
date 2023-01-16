package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.SplitPanel
import javax.swing.JComponent
import javax.swing.JSplitPane

class SwingSplitPanel<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val left: Component<Constraint>,
    override val right: Component<Constraint>,
    override val orientation: Orientation,
    override val continuous: Boolean,
    override val touchExpand: Boolean,
) : SplitPanel<C>, JSplitPane(
    Orientation::class.java.enumConstants.reversed().lastIndexOf(orientation),
    continuous,
    left as JComponent,
    right as JComponent,
) {
    init {
        isEnabled = enabled

        isOneTouchExpandable = touchExpand
    }
}