package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.api.CloseOperation
import com.deflatedpickle.guikt.backend.javafx.JavaFXFrame
import com.deflatedpickle.guikt.impl.LayoutManager
import com.deflatedpickle.guikt.widget.Frame

object JavaFXBackend : Backend<Any>() {
    var layout: LayoutManager = LayoutManager.None
    var title: String = ""
    var width: Int = 420
    var height: Int = 360
    var closeOperation: CloseOperation = CloseOperation.EXIT
    var components: ComponentMap = linkedMapOf()

    init {
        registry[Frame::class] = JavaFXFrame::class
    }
}