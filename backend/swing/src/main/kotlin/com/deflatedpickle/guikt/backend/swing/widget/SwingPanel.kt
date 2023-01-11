package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.Panel
import java.awt.Component
import java.awt.LayoutManager
import javax.swing.JPanel

class SwingPanel<C : Constraint, T : Layout>(
    override val constraint: C,
    override val layout: T,
    override val components: ComponentMap
) : Panel<C, T>, JPanel() {
    init {
        this.setLayout(this.layout.build() as LayoutManager)

        for ((w, c) in components) {
            this.add(w as Component, /*c.build()*/)
        }
    }
}