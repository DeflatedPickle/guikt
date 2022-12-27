package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.backend.swing.SwingButton
import com.deflatedpickle.guikt.backend.swing.SwingFrame
import com.deflatedpickle.guikt.backend.swing.SwingLabel
import com.deflatedpickle.guikt.backend.swing.SwingLayoutBorder
import com.deflatedpickle.guikt.backend.swing.SwingLayoutFlow
import com.deflatedpickle.guikt.backend.swing.SwingPanel
import com.deflatedpickle.guikt.impl.Constraint.Border
import com.deflatedpickle.guikt.impl.Layout.Border as LayoutBorder
import com.deflatedpickle.guikt.impl.Layout.Flow as LayoutFlow
import com.deflatedpickle.guikt.widget.Button
import com.deflatedpickle.guikt.widget.Frame
import com.deflatedpickle.guikt.widget.Label
import com.deflatedpickle.guikt.widget.Panel
import java.awt.Container

object SwingBackend : Backend() {
    init {
        registry[Frame::class] = SwingFrame::class
        registry[Panel::class] = SwingPanel::class
        registry[Button::class] = SwingButton::class
        registry[Label::class] = SwingLabel::class

        registry[LayoutBorder::class] = SwingLayoutBorder::class
        registry[LayoutFlow::class] = SwingLayoutFlow::class
    }
}