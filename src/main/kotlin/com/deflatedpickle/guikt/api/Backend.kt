package com.deflatedpickle.guikt.api

import com.deflatedpickle.marvin.registry.Registry
import kotlin.reflect.KClass

open class Backend<T : Any> {
    val registry = Registry<KClass<out Component<*>>, KClass<out Component<*>>>()
}