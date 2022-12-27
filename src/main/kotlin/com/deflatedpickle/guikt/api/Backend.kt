package com.deflatedpickle.guikt.api

import kotlin.reflect.KClass

open class Backend {
    val registry = mutableMapOf<KClass<out BackendObject>, KClass<out BackendObject>>()
}