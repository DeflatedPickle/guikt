/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.guikt

import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.impl.Constraint

typealias ComponentList = ArrayList<out Component<Constraint>>
typealias ComponentMap = LinkedHashMap<Component<*>, Constraint>