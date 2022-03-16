/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.guikt.api

import com.deflatedpickle.guikt.impl.Constraint

interface Builder<C : Constraint> {
    fun build(): Component<C>
}
