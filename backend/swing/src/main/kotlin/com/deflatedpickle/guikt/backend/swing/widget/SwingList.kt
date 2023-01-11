package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Event
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.List
import java.util.Vector
import javax.swing.JList

class SwingList<T : Any>(
    override val constraint: Constraint,
    override val enabled: Boolean,
    override val items: MutableList<T>,
    override val index: Int,
    override val onSelection: MutableList<Listener>,
) : List<T>, JList<T>() {
    init {
        isEnabled = enabled

        setListData(Vector(items))

        selectedIndex = index

        onSelection.forEach { e -> addListSelectionListener { e.action(Event(it.source)) } }
    }
}