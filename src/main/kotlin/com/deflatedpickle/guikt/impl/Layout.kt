/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("CanSealedSubClassBeObject", "unused", "MemberVisibilityCanBePrivate")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Alignment
import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Builder
import kotlin.reflect.KClass

sealed class Layout : BackendObject, Builder<Any> {
    object None : Layout() {
        override fun toConstraint(): KClass<out Constraint> = Constraint.None::class

        override fun build() = GuiKT.backend.registry[None::class]?.objectInstance as Any
    }

    data class Border(
        val hGap: Int = 0,
        val vGap: Int = 0
    ) : Layout() {
        override fun toConstraint() = Constraint.Border::class

        override fun build() = GuiKT.backend.registry[Border::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
            hGap, vGap,
        ) as Any
    }

    data class Flow(
        val alignment: Alignment = Alignment.CENTER,
        val alignOnBaseline: Boolean = false,
        val hGap: Int = 5,
        val vGap: Int = 5
    ) : Layout() {
        override fun toConstraint() = Constraint.Flow::class

        override fun build() = GuiKT.backend.registry[Flow::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
            alignment, alignOnBaseline, hGap, vGap,
        ) as Any
    }

    abstract fun toConstraint() : KClass<out Constraint>
}
