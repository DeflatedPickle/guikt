package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.Frame
import java.awt.Dimension
import javax.swing.JFrame

class SwingFrame<T : LayoutManager>(
    layout: T,
    title: String,
    width: Int,
    height: Int,
    closeOperation: CloseOperation,
    components: ComponentMap,
) : Frame<T>(layout, title, width, height, closeOperation, components) {
    init {
        JFrame().apply {
            this.title = title
            this.size = Dimension(
                width,
                height
            )
            this.defaultCloseOperation = closeOperation.ordinal
            // this.layout = layout.toBackend()

            isVisible = true
        }
    }
}