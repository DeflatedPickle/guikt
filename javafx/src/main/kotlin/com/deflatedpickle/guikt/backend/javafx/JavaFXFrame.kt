package com.deflatedpickle.guikt.backend.javafx

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.backend.JavaFXBackend
import com.deflatedpickle.guikt.backend.javafx.fix.JavaFXFrameFix
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.Frame
import javafx.application.Application

class JavaFXFrame<T : LayoutManager>(
    layout: T,
    title: String,
    width: Int,
    height: Int,
    closeOperation: CloseOperation,
    components: ComponentMap,
) : Frame<T>(layout, title, width, height, closeOperation, components) {
    init {
        JavaFXBackend.layout = layout
        JavaFXBackend.title = title
        JavaFXBackend.width = width
        JavaFXBackend.height = height
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