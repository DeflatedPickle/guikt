@file:Suppress("unused")

package com.deflatedpickle.guikt.backend

import com.deflatedpickle.guikt.api.Backend
import com.deflatedpickle.guikt.backend.swt.SwtFrame
import com.deflatedpickle.guikt.widget.Frame
import java.awt.Container

object SwtBackend : Backend() {
    init {
        registry[Frame::class] = SwtFrame::class
    }
}