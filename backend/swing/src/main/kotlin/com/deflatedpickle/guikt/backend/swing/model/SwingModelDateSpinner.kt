package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Calendar
import java.util.Date
import javax.swing.DefaultBoundedRangeModel
import javax.swing.SpinnerDateModel
import javax.swing.SpinnerNumberModel

class SwingModelDateSpinner<T : Number>(
    val _value: T = Date() as T,
    val _start: Comparable<Date> = Date(),
    val _end: Comparable<Date> = Date(),
    val field: Calendar = Calendar.DAY_OF_MONTH,
) : BackendObject, SpinnerDateModel() {
    init {
        this.value = this._value
        this.start = this._start
        this.end = this._end
        this.calendarField = this.field.ordinal
    }
}