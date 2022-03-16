/* Copyright (c) 2022 DeflatedPickle under the MIT license */

@file:Suppress("UNCHECKED_CAST")

package com.deflatedpickle.guikt.impl

import com.deflatedpickle.guikt.api.BackendObject

data class Font(
    val family: String = "",
    val bold: Boolean = false,
    val italic: Boolean = false,
    val underline: Boolean = false,
    val size: Int = 0,
) : BackendObject
