package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.api.Alignment
import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Button
import java.awt.BorderLayout
import java.awt.FlowLayout
import javax.swing.JButton

class SwingLayoutFlow(
    val alignment: Alignment = Alignment.CENTER,
    val _alignOnBaseline: Boolean = false,
    val hGap: Int = 5,
    val vGap: Int = 5
) : BackendObject, FlowLayout() {
    init {
        this.setAlignment(this.alignment.ordinal)
        this.alignOnBaseline = this._alignOnBaseline
        this.hgap = this.hGap
        this.vgap = this.vGap
    }
}