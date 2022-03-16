package com.deflatedpickle.guikt.backend.javafx.fix

import com.deflatedpickle.guikt.backend.JavaFXBackend
import com.deflatedpickle.guikt.backend.JavaFXBackend.title
import javafx.application.Application
import javafx.stage.Stage

class JavaFXFrameFix : Application() {
    override fun start(stage: Stage) {
        stage.title = title
        stage.width = JavaFXBackend.size.width.toDouble()
        stage.height = JavaFXBackend.size.height.toDouble()

        stage.show()
    }
}