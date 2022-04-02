package com.josedev.pokedex.util

sealed class ResourceClass<T>(val data: T? = null, val message: String? = null){
    class Success<T>(data: T): ResourceClass<T>(data)
    class Error<T>(message: String, data: T? = null): ResourceClass<T>(data, message)
    class Loading<T>(data: T? = null): ResourceClass<T>(data)
}
