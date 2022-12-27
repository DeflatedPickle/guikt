package com.deflatedpickle.guikt.backend.swing

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.api.Dimension
import com.deflatedpickle.guikt.impl.Layout
import com.deflatedpickle.guikt.widget.Frame
import java.awt.Component
import java.awt.LayoutManager
import java.awt.Dimension as AwtDimension
import javax.swing.JFrame

class SwingFrame<T : Layout>(
    override val layout: T,
    override val _title: String,
    override val _size: Dimension,
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

        this.setLayout(this.layout.build() as LayoutManager)

        for ((w, c) in components) {
            this.add(w as Component, /*c.build()*/)
        }

        isVisible = true
    }
}