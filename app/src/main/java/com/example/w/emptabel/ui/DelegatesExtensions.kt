package com.example.w.emptabel.ui

import kotlin.reflect.KProperty

object DelegatesExt{
    fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()

}

class NotNullSingleValueVar<T> {
    private var value: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T{
        return value ?: throw IllegalStateException("${property.name} not init")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T){
        this.value = if(this.value == null) value
        else throw IllegalArgumentException("${property.name} already init")
    }
}