/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.guikt.api

import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.LayoutManager

abstract class Container<T : LayoutManager, C : Constraint> : Component<C>
