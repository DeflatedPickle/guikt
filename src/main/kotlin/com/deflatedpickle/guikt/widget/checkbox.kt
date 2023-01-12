/* Copyright (c) 2021 DeflatedPickle under the MIT license */

@file:Suppress("MemberVisibilityCanBePrivate", "unused", "PropertyName")

package com.deflatedpickle.guikt.widget

import com.deflatedpickle.guikt.GuiKT
import com.deflatedpickle.guikt.api.Component
import com.deflatedpickle.guikt.api.GuiDSL
import com.deflatedpickle.guikt.api.Listener
import com.deflatedpickle.guikt.impl.Constraint
import com.deflatedpickle.guikt.impl.ContainerBuilder
import com.deflatedpickle.guikt.impl.Icon
import com.deflatedpickle.guikt.impl.WidgetBuilder

fun <C : Constraint> ContainerBuilder<*>.checkbox(
    constraint: C,
    block: CheckBoxBuilder<C>.() -> Unit = {}
) = CheckBoxBuilder(constraint).apply(block).build().apply { components[this] = constraint }

interface CheckBox<C : Constraint> : Component<C> {
    val constraint: C

    val _text: String?
    val _icon: Icon?
    val _mnemonic: Char?

    val onClick: MutableList<Listener>
}

@GuiDSL
class CheckBoxBuilder<C : Constraint>(
    var constraint: C
) : WidgetBuilder<CheckBox<C>>() {
    var enabled = true

    var text: String? = null
    var icon: Icon? = null
    var mnemonic: Char? = null

    var onClick: MutableList<Listener> = mutableListOf()

    override fun build() = GuiKT.backend.registry[CheckBox::class]?.constructors?.maxByOrNull { it.parameters.count() }!!.call(
        constraint, enabled, text, icon, mnemonic, onClick,
    ) as CheckBox<C>
}