package com.deflatedpickle.guikt.api

data class Dimension(
    val width: Int,
    val height: Int,
)

infix fun Int.x(other: Int) = Dimension(this, other)