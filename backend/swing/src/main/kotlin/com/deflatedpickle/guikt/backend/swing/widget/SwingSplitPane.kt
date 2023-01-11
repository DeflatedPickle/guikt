package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Icon
import com.deflatedpickle.guikt.widget.Button
import com.deflatedpickle.guikt.widget.SplitPane
import javax.swing.ImageIcon
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JSplitPane

class SwingSplitPane<C : Constraint>(
    override val constraint: C,
    override val left: Component<Constraint>,
    override val right: Component<Constraint>,
    override val orientation: Orientation,
    override val continuous: Boolean,
    override val touchExpand: Boolean,
) : SplitPane<C>, JSplitPane(
    Orientation::class.java.enumConstants.reversed().lastIndexOf(orientation),
    continuous,
    left as JComponent,
    right as JComponent,
) {
    init {
        isOneTouchExpandable = touchExpand
    }
}