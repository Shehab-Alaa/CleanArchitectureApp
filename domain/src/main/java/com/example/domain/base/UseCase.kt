package com.example.domain.base


interface UseCase {
    interface ResourceUseCase<T : Any> : UseCase {
        suspend fun executeAsync(): Resource<T>
    }
}
