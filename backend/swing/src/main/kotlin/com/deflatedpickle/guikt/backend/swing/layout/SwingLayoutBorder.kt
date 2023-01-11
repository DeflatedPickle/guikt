package com.deflatedpickle.guikt.backend.swing.layout

import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Button
import java.awt.BorderLayout
import javax.swing.JButton

class SwingLayoutBorder(
    val hGap: Int = 0,
    val vGap: Int = 0
) : BackendObject, BorderLayout() {
    init {
        this.hgap = this.hGap
        this.vgap = this.vGap
    }
}