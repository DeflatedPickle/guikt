package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Label
import javax.swing.JLabel

class SwingLabel<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val _text: String,
) : Label<C>, JLabel() {
    init {
        isEnabled = enabled

        this.text = _text
    }
}