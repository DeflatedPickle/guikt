package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.widget.ComboBox
import javax.swing.ComboBoxModel
import javax.swing.DefaultComboBoxModel
import javax.swing.JComboBox

class SwingComboBox<T : Any>(
    override val constraint: Constraint,
    override val enabled: Boolean,
    override val editable: Boolean,
    override val model: Model.ComboBox.Default<T>,
    override val index: Int,
    override val onItem: MutableList<Listener>,
    override val onClick: MutableList<Listener>,
) : ComboBox<T>, JComboBox<T>() {
    init {
        isEnabled = enabled

        setEditable(editable)

        setModel(model.build() as DefaultComboBoxModel<T>)

        selectedIndex = index

        onItem.forEach { e -> addItemListener { e.action(Event(it.source)) } }
        onClick.forEach { e -> addActionListener { e.action(Event(it.source)) } }
    }
}