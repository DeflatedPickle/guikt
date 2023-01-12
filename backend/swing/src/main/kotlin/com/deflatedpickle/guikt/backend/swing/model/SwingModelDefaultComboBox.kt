package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.impl.Model
import javax.swing.DefaultBoundedRangeModel
import javax.swing.DefaultComboBoxModel
import javax.swing.DefaultListModel
import javax.swing.ListModel

class SwingModelDefaultComboBox<T : Any>(
    val values: List<T>,
) : BackendObject, DefaultComboBoxModel<T>() {
    init {
        addAll(this.values)
    }
}