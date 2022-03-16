/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("CanSealedSubClassBeObject", "unused", "MemberVisibilityCanBePrivate")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.api.Alignment
import com.deflatedpickle.guikt.api.BackendObject
import kotlin.reflect.KClass

sealed class LayoutManager : BackendObject {
    object None : LayoutManager() {
        override fun toConstraint(): KClass<out Constraint> = Constraint.None::class
    }

    data class Border(
        val hGap: Int = 0,
        val vGap: Int = 0
    ) : LayoutManager() {
        override fun toConstraint(): KClass<out Constraint> = Constraint.Border::class
    }

    data class Flow(
        val alignment: Alignment = Alignment.CENTER,
        val alignOnBaseline: Boolean = false,
        val hGap: Int = 5,
        val vGap: Int = 5
    ) : LayoutManager() {
        override fun toConstraint(): KClass<out Constraint> = Constraint.Flow::class
    }

    abstract fun toConstraint() : KClass<out Constraint>
}
