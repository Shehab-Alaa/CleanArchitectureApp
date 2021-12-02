package com.example.presentation.util

data class Resource<out T>(val status: Status, val data: T? = null, val message: String? = null) {

    companion object {
        fun <T> success(data: T?=null, msg: String? = null): Resource<T> {
            return Resource(Status.SUCCESS, data, msg)
        }

        fun <T> message(msg: String?, data: T? = null): Resource<T> {
            return Resource(Status.MESSAGE, data, msg)
        }

        fun <T> loading(data: T?=null): Resource<T> {
            return Resource(Status.LOADING, data)
        }
    }


}

enum class Status {
    SUCCESS,
    MESSAGE,
    LOADING
}