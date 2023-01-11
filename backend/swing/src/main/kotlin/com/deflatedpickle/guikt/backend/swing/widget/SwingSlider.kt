package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.widget.Slider
import javax.swing.JSlider

class SwingSlider<C : Constraint>(
    override val constraint: C,
    override val _orientation: Orientation,
    override val min: Int,
    override val max: Int,
    override val _value: Int,
) : Slider<C>, JSlider() {
    init {
        orientation = _orientation.ordinal
        minimum = min
        maximum = max
        value = _value
    }
}