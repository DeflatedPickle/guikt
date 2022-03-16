package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.backend.swing.SwingFrame
import com.deflatedpickle.guikt.widget.Frame
import java.awt.Container

object SwingBackend : Backend<Container>() {
    init {
        registry[Frame::class] = SwingFrame::class
    }
}