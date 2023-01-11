package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Icon
import com.deflatedpickle.guikt.widget.CheckBox
import javax.swing.ImageIcon
import javax.swing.JCheckBox

class SwingCheckBox<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val _text: String?,
    override val _icon: Icon?,
    override val _mnemonic: Char?,
    override val onClick: MutableList<Listener>,
) : CheckBox<C>, JCheckBox() {
    init {
        isEnabled = enabled

        _text?.let { this.text = it }
        _icon?.let { this.icon = ImageIcon(it.name, it.description) }
        _mnemonic?.let { this.mnemonic = it.code }

        onClick.forEach { e -> addActionListener { e.action(Event(it.source)) } }
    }
}