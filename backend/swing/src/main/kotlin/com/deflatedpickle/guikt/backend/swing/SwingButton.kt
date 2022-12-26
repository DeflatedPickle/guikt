package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Button
import javax.swing.JButton

class SwingButton<C : Constraint>(
    override val constraint: C,
    override val _text: String,
) : Button<C>, JButton() {
    init {
        this.text = _text
    }
}