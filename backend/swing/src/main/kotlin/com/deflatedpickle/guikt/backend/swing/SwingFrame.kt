package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.Frame
import java.awt.Dimension as AwtDimension
import javax.swing.JFrame

class SwingFrame<T : LayoutManager>(
    override val layout: T,
    override val _title: String,
    override val _size: com.deflatedpickle.guikt.api.Dimension,
    override val closeOperation: CloseOperation,
    override val components: ComponentMap,
) : Frame<T>, JFrame() {
    init {
        this.title = _title
        this.size = AwtDimension(
            _size.width,
            _size.height,
        )
        this.defaultCloseOperation = closeOperation.ordinal
        // this.layout = layout.toBackend()

        isVisible = true
    }
}