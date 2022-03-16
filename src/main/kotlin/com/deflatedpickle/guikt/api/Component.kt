/* Copyright (c) 2021 DeflatedPickle under the MIT license */

package com.deflatedpickle.guikt.api

import com.deflatedpickle.guikt.impl.Constraint

interface Component<out C : Constraint> : BackendObject
