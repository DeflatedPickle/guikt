/* Copyright (c) 2021-2022 DeflatedPickle under the MIT license */

@file:Suppress("UNCHECKED_CAST")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.ComponentMap
import com.deflatedpickle.guikt.api.Builder

abstract class ContainerBuilder<T> : Builder<T> {
    internal val components = ComponentMap()
}
