package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.api.Orientation
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.widget.Slider
import javax.swing.BoundedRangeModel
import javax.swing.JSlider

class SwingSlider<C : Constraint>(
    override val constraint: C,
    override val enabled: Boolean,
    override val _orientation: Orientation,
    override val model: Model.BoundedRange.Integer
) : Slider<C>, JSlider() {
    init {
        isEnabled = enabled

        orientation = _orientation.ordinal
        setModel(model.build() as BoundedRangeModel)
    }
}