package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.backend.swing.layout.SwingLayoutBorder
import com.deflatedpickle.guikt.backend.swing.layout.SwingLayoutFlow
import com.deflatedpickle.guikt.backend.swing.model.SwingModelDateSpinner
import com.deflatedpickle.guikt.backend.swing.model.SwingModelDefaultComboBox
import com.deflatedpickle.guikt.backend.swing.model.SwingModelDefaultList
import com.deflatedpickle.guikt.backend.swing.model.SwingModelIntegerBoundRange
import com.deflatedpickle.guikt.backend.swing.model.SwingModelListSpinner
import com.deflatedpickle.guikt.backend.swing.model.SwingModelNumberSpinner
import com.deflatedpickle.guikt.backend.swing.widget.SwingButton
import com.deflatedpickle.guikt.backend.swing.widget.SwingCheckBox
import com.deflatedpickle.guikt.backend.swing.widget.SwingComboBox
import com.deflatedpickle.guikt.backend.swing.widget.SwingFrame
import com.deflatedpickle.guikt.backend.swing.widget.SwingLabel
import com.deflatedpickle.guikt.backend.swing.widget.SwingList
import com.deflatedpickle.guikt.backend.swing.widget.SwingPanel
import com.deflatedpickle.guikt.backend.swing.widget.SwingProgressBar
import com.deflatedpickle.guikt.backend.swing.widget.SwingRadioButton
import com.deflatedpickle.guikt.backend.swing.widget.SwingSlider
import com.deflatedpickle.guikt.backend.swing.widget.SwingSpinner
import com.deflatedpickle.guikt.backend.swing.widget.SwingSplitPanel
import com.deflatedpickle.guikt.backend.swing.widget.SwingTabbedPanel
import com.deflatedpickle.guikt.backend.swing.widget.SwingTextArea
import com.deflatedpickle.guikt.backend.swing.widget.SwingTextField
import com.deflatedpickle.guikt.backend.swing.widget.SwingToggleButton
import com.deflatedpickle.guikt.widget.Button
import com.deflatedpickle.guikt.widget.CheckBox
import com.deflatedpickle.guikt.widget.ComboBox
import com.deflatedpickle.guikt.widget.Frame
import com.deflatedpickle.guikt.widget.Label
import com.deflatedpickle.guikt.widget.List
import com.deflatedpickle.guikt.widget.Panel
import com.deflatedpickle.guikt.widget.ProgressBar
import com.deflatedpickle.guikt.widget.RadioButton
import com.deflatedpickle.guikt.widget.Slider
import com.deflatedpickle.guikt.widget.Spinner
import com.deflatedpickle.guikt.widget.SplitPanel
import com.deflatedpickle.guikt.widget.TabbedPanel
import com.deflatedpickle.guikt.widget.TextArea
import com.deflatedpickle.guikt.widget.TextField
import com.deflatedpickle.guikt.widget.ToggleButton
import kotlin.collections.set
import com.deflatedpickle.guikt.impl.Layout.Border as LayoutBorder
import com.deflatedpickle.guikt.impl.Layout.Flow as LayoutFlow
import com.deflatedpickle.guikt.impl.Model.BoundedRange.Integer as ModelIntegerBoundedRange
import com.deflatedpickle.guikt.impl.Model.ComboBox.Default as ModelDefaultComboBox
import com.deflatedpickle.guikt.impl.Model.List.Default as ModelDefaultList
import com.deflatedpickle.guikt.impl.Model.Spinner.Date as ModelDateSpinner
import com.deflatedpickle.guikt.impl.Model.Spinner.List as ModelListSpinner
import com.deflatedpickle.guikt.impl.Model.Spinner.Number as ModelNumberSpinner

object SwingBackend : Backend() {
    init {
        registry[Frame::class] = SwingFrame::class
        registry[Panel::class] = SwingPanel::class

        registry[SplitPanel::class] = SwingSplitPanel::class
        registry[TabbedPanel::class] = SwingTabbedPanel::class

        registry[Button::class] = SwingButton::class
        registry[ToggleButton::class] = SwingToggleButton::class
        registry[CheckBox::class] = SwingCheckBox::class
        registry[RadioButton::class] = SwingRadioButton::class

        registry[TextField::class] = SwingTextField::class
        registry[TextArea::class] = SwingTextArea::class

        registry[Label::class] = SwingLabel::class
        registry[Slider::class] = SwingSlider::class
        registry[ComboBox::class] = SwingComboBox::class
        registry[List::class] = SwingList::class
        registry[ProgressBar::class] = SwingProgressBar::class
        registry[Spinner::class] = SwingSpinner::class

        registry[LayoutBorder::class] = SwingLayoutBorder::class
        registry[LayoutFlow::class] = SwingLayoutFlow::class

        registry[ModelIntegerBoundedRange::class] = SwingModelIntegerBoundRange::class
        registry[ModelDateSpinner::class] = SwingModelDateSpinner::class
        registry[ModelListSpinner::class] = SwingModelListSpinner::class
        registry[ModelNumberSpinner::class] = SwingModelNumberSpinner::class
        registry[ModelDefaultList::class] = SwingModelDefaultList::class
        registry[ModelDefaultComboBox::class] = SwingModelDefaultComboBox::class
    }
}