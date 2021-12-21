package com.example.domain.usecase


interface UseCase {
    interface ResourceUseCase<T : Any> : UseCase {
        suspend fun executeAsync(): Resource<T>
    }
}
