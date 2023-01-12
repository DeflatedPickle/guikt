package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import javax.swing.DefaultBoundedRangeModel
import javax.swing.SpinnerNumberModel

class SwingModelNumberSpinner<T : Number>(
    val _value: T = 0 as T,
    val min: Comparable<T> = 0 as Comparable<T>,
    val max: Comparable<T> = 0 as Comparable<T>,
    val step: T = 0 as T,
) : BackendObject, SpinnerNumberModel() {
    init {
        this.value = this._value
        this.minimum = this.min
        this.maximum = this.max
        this.stepSize = this.step
    }
}