package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Label
import com.deflatedpickle.guikt.widget.TextField
import javax.swing.JLabel
import javax.swing.JTextField

class SwingTextField<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val _text: String,
    override val _columns: Int,
) : TextField<C>, JTextField() {
    init {
        isEnabled = enabled

        this.text = _text
        this.columns = _columns
    }
}