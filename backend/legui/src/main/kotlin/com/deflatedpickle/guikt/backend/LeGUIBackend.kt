package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.backend.legui.LeGUIFrame
import com.deflatedpickle.guikt.widget.Frame

object LeGUIBackend : Backend() {
    init {
        registry[Frame::class] = LeGUIFrame::class
    }
}