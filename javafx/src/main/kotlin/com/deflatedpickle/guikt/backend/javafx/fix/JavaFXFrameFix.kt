package com.deflatedpickle.guikt.backend.javafx.fix

import com.deflatedpickle.guikt.backend.JavaFXBackend.height
import com.deflatedpickle.guikt.backend.JavaFXBackend.title
import com.deflatedpickle.guikt.backend.JavaFXBackend.width
import javafx.application.Application
import javafx.stage.Stage

class JavaFXFrameFix : Application() {
    override fun start(stage: Stage) {
        stage.title = title
        stage.width = width.toDouble()
        stage.height = height.toDouble()

        stage.show()
    }
}