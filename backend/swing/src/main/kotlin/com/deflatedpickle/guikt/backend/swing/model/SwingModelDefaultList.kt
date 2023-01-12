package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import javax.swing.DefaultBoundedRangeModel
import javax.swing.DefaultListModel
import javax.swing.ListModel

class SwingModelDefaultList<T : Any>(
    val values: List<T>,
) : BackendObject, DefaultListModel<T>() {
    init {
        addAll(this.values)
    }
}