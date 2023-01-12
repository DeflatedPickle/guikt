package com.deflatedpickle.guikt.backend.swing.widget

import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.Model
import com.deflatedpickle.guikt.widget.Spinner
import javax.swing.BoundedRangeModel
import javax.swing.JSpinner
import javax.swing.SpinnerModel

class SwingSpinner<T : Number>(
    override val constraint: Constraint,
    override val enabled: Boolean,
    override val model: Model.Spinner.Number<T>,
) : Spinner<T>, JSpinner() {
    init {
        isEnabled = enabled

        setModel(model.build() as SpinnerModel)
    }
}