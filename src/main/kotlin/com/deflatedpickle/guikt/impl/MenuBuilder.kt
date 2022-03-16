/* Copyright (c) 2021-2022 DeflatedPickle under the MIT license */

@file:Suppress("UNCHECKED_CAST")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.ComponentList
import com.deflatedpickle.guikt.api.Builder

abstract class MenuBuilder<T, C : Constraint> : Builder<C> {
    internal val components = ComponentList()
}
