package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.api.Dimension
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.Frame
import com.deflatedpickle.guikt.widget.Panel
import java.awt.Component
import java.awt.Dimension as AwtDimension
import javax.swing.JFrame
import javax.swing.JPanel

class SwingPanel<C : Constraint, T : Layout>(
    override val constraint: C,
    override val layout: T,
    override val components: ComponentMap
) : Panel<C, T>, JPanel() {
    init {
        for ((w, c) in components) {
            this.add(w as Component)
        }
    }
}