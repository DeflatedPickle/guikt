package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.ComboBox
import javax.swing.JComboBox

class SwingComboBox<T : Any>(
    override val constraint: Constraint,
    override val enabled: Boolean,
    override val editable: Boolean,
    override val items: MutableList<T>,
    override val index: Int,
    override val onItem: MutableList<Listener>,
    override val onClick: MutableList<Listener>,
) : ComboBox<T>, JComboBox<T>() {
    init {
        isEnabled = enabled

        setEditable(editable)

        for (i in items) {
            addItem(i)
        }

        selectedIndex = index

        onItem.forEach { e -> addItemListener { e.action(Event(it.source)) } }
        onClick.forEach { e -> addActionListener { e.action(Event(it.source)) } }
    }
}