/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("CanSealedSubClassBeObject", "MemberVisibilityCanBePrivate", "unused")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.api.Alignment
import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Compass

sealed class Constraint : BackendObject {
    object None : Constraint()

    data class Border(
        val side: Compass = Compass.ROSE
    ) : Constraint()

    data class Flow(
        val alignment: Alignment = Alignment.CENTER
    ) : Constraint()
}
