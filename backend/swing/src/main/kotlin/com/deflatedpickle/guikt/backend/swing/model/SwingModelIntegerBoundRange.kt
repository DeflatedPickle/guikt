package com.deflatedpickle.guikt.backend.swing.model

import com.deflatedpickle.guikt.api.BackendObject
import javax.swing.DefaultBoundedRangeModel

class SwingModelIntegerBoundRange(
    val _value: Int = 0,
    val _extent: Int = 0,
    val min: Int = 0,
    val max: Int = 0,
) : BackendObject, DefaultBoundedRangeModel() {
    init {
        this.value = this._value
        this.extent = this._extent
        this.minimum = this.min
        this.maximum = this.max
    }
}