/* Copyright (c) 2021-2022 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "UNCHECKED_CAST", "unused")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Builder
import com.deflatedpickle.guikt.api.Calendar
import java.util.Date as JDate
import kotlin.Number as KNumber
import kotlin.collections.List as KList

sealed interface Model<out T> : BackendObject, Builder<Any> {
    sealed interface Spinner<out T> : Model<T> {
        data class Date<T : JDate>(
            val value: T = java.util.Date() as T,
            val start: Comparable<JDate> = java.util.Date(),
            val end: Comparable<JDate> = java.util.Date(),
            val field: Calendar = Calendar.DAY_OF_MONTH,
        ) : Spinner<JDate> {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, start, end, field,
            ) as Any
        }

        data class List<T : Any?>(
            val values: KList<T> = listOf()
        ) : Spinner<T> {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }

        data class Number<T : KNumber>(
            val value: T = 0 as T,
            val min: Comparable<T> = 0 as Comparable<T>,
            val max: Comparable<T> = 0 as Comparable<T>,
            val step: T = 0 as T,
        ) : Spinner<T> {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, min, max, step,
            ) as Any
        }
    }

    sealed interface List<T> : Model<T> {
        data class Default<T>(
            val values: KList<T> = listOf()
        ) : List<T> {
            override fun build() = GuiKT.backend.registry[Default::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }
    }

    sealed interface ComboBox<T> : Model<T> {
        data class Default<T>(
            val values: KList<T> = listOf()
        ) : ComboBox<T> {
            override fun build() = GuiKT.backend.registry[Default::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }
    }

    sealed interface BoundedRange<out T> : Model<T> {
        data class Integer(
            val value: Int = 0,
            val extent: Int = 0,
            val min: Int = 0,
            val max: Int = 0
        ) : BoundedRange<Int> {
            override fun build() = GuiKT.backend.registry[Integer::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, extent, min, max,
            ) as Any
        }
    }
}
