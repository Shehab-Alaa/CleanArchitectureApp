package com.example.domain.usecase

interface UseCase {
    interface ResourceUseCase<T : Any> : UseCase {
        suspend fun executeAsync(param: Map<String, Any>? = null): Resource<T>
    }
}
