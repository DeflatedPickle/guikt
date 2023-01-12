/* Copyright (c) 2021-2022 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "UNCHECKED_CAST", "unused")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.BackendObject
import com.deflatedpickle.guikt.api.Builder
import com.deflatedpickle.guikt.api.Calendar
import com.deflatedpickle.guikt.impl.Layout.Border
import com.deflatedpickle.guikt.impl.Model.BoundedRange.Integer
import java.util.Date
import javax.swing.BoundedRangeModel
import javax.swing.DefaultBoundedRangeModel
import javax.swing.DefaultListModel
import javax.swing.ListModel
import javax.swing.SpinnerDateModel
import javax.swing.SpinnerListModel
import javax.swing.SpinnerModel
import javax.swing.SpinnerNumberModel
import kotlin.collections.listOf
import java.util.Date as JDate
import kotlin.Number as KNumber
import kotlin.collections.List as KList

sealed class Model<out M, out T> : BackendObject, Builder<Any> {
    sealed class Spinner<out M : SpinnerModel, out T> : Model<SpinnerModel, T>() {
        class Date<T : JDate>(
            val value: T = java.util.Date() as T,
            val start: Comparable<JDate> = java.util.Date(),
            val end: Comparable<JDate> = java.util.Date(),
            val field: Calendar = Calendar.DAY_OF_MONTH,
        ) : Spinner<SpinnerDateModel, JDate>() {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, start, end, field,
            ) as Any
        }

        class List<T : Any?>(
            val values: KList<T> = listOf()
        ) : Spinner<SpinnerListModel, T>() {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }

        class Number<T : KNumber>(
            val value: T = 0 as T,
            val min: Comparable<T> = 0 as Comparable<T>,
            val max: Comparable<T> = 0 as Comparable<T>,
            val step: T = 0 as T,
        ) : Spinner<SpinnerNumberModel, T>() {
            override fun build() = GuiKT.backend.registry[Number::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, min, max, step,
            ) as Any
        }
    }

    sealed class List<out M : ListModel<T>, T> : Model<M, T>() {
        class Default<T>(
            val values: KList<T> = listOf()
        ) : List<DefaultListModel<T>, T>() {
            override fun build() = GuiKT.backend.registry[Default::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }
    }

    sealed class ComboBox<out M : ListModel<T>, T> : Model<M, T>() {
        class Default<T>(
            val values: KList<T> = listOf()
        ) : ComboBox<DefaultListModel<T>, T>() {
            override fun build() = GuiKT.backend.registry[Default::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                values,
            ) as Any
        }
    }

    sealed class BoundedRange<out M : BoundedRangeModel, out T> : Model<BoundedRangeModel, T>() {
        class Integer(
            val value: Int = 0,
            val extent: Int = 0,
            val min: Int = 0,
            val max: Int = 0
        ) : BoundedRange<BoundedRangeModel, Int>() {
            override fun build() = GuiKT.backend.registry[Integer::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
                value, extent, min, max,
            ) as Any
        }
    }
}
