package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository
import com.example.domain.usecase.Resource
import com.example.domain.usecase.UseCase

open class GetMoviesSearchUseCase(
    private val moviesRepository: IMoviesRepository
) : UseCase.ResourceUseCase<List<Movie>> {

    companion object {
        const val QUERY_PARAM = "query"
    }

    override suspend fun executeAsync(param: Map<String, Any>?): Resource<List<Movie>> {
        return try {
            val movies = moviesRepository.getMoviesSearchAsync(param?.get(QUERY_PARAM).toString())
            if (movies.isEmpty()) return Resource.empty()
            Resource.success(movies)
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }
}