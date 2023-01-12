package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Label
import com.deflatedpickle.guikt.widget.TextArea
import com.deflatedpickle.guikt.widget.TextField
import javax.swing.JLabel
import javax.swing.JTextArea
import javax.swing.JTextField

class SwingTextArea<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val _text: String,
    override val _rows: Int,
    override val _columns: Int,
    override val wrap: Boolean,
) : TextArea<C>, JTextArea() {
    init {
        isEnabled = enabled

        this.text = _text
        this.rows = _rows
        this.columns = _columns
        this.lineWrap = wrap
    }
}