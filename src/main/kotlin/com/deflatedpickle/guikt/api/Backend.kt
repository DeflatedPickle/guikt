package com.deflatedpickle.guikt.api

import kotlin.reflect.KClass

open class Backend<T : Any> {
    val registry = mutableMapOf<KClass<out Component<*>>, KClass<out Component<*>>>()
}