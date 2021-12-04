package com.example.domain.usecase


abstract class UseCase<out T> where T : Any {

    abstract fun createObservable(): T

    open fun onCleared() {}
}