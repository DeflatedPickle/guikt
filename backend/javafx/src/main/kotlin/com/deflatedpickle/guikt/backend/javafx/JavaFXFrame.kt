package com.deflatedpickle.guikt.backend.javafx

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.backend.JavaFXBackend
import com.deflatedpickle.guikt.backend.javafx.fix.JavaFXFrameFix
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.Frame
import javafx.application.Application

class JavaFXFrame<T : Layout>(
    override val layout: T,
    override val enabled: Boolean,
    override val _title: String,
    override val _size: com.deflatedpickle.guikt.api.Dimension,
    override val closeOperation: CloseOperation,
    override val components: ComponentMap,
) : Frame<T> {
    init {
        JavaFXBackend.layout = layout
        JavaFXBackend.title = _title
        JavaFXBackend.size = _size
        JavaFXBackend.closeOperation = closeOperation
        JavaFXBackend.components = components

        Thread {
            try {
                Application.launch(JavaFXFrameFix::class.java)
            } catch (_: RuntimeException) {
            }
        }.start()
    }
}