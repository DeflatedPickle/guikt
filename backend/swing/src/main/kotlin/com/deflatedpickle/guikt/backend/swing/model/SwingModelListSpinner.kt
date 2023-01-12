package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Calendar
import java.util.Date
import javax.swing.DefaultBoundedRangeModel
import javax.swing.SpinnerDateModel
import javax.swing.SpinnerListModel
import javax.swing.SpinnerNumberModel

class SwingModelListSpinner<T : Number>(
    val values: List<T> = listOf()
) : BackendObject, SpinnerListModel() {
    init {
        this.value = this.values
    }
}