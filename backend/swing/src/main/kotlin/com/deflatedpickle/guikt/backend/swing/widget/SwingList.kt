package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.widget.List
import java.util.Vector
import javax.swing.DefaultListModel
import javax.swing.JList
import javax.swing.ListModel

class SwingList<T : Any>(
    override val constraint: Constraint,
    override val enabled: Boolean,
    override val model: Model.List.Default<T>,
    override val index: Int,
    override val onSelection: MutableList<Listener>,
) : List<T>, JList<T>() {
    init {
        isEnabled = enabled

        setModel(model.build() as DefaultListModel<T>)

        selectedIndex = index

        onSelection.forEach { e -> addListSelectionListener { e.action(Event(it.source)) } }
    }
}