package com.example.domain.usecase.movie

import com.example.domain.base.Resource
import com.example.domain.base.UseCase
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository

open class GetMoviesUseCase(
    private val moviesRepository: IMoviesRepository
) : UseCase.ResourceUseCase<List<Movie>>{

    override suspend fun executeAsync(): Resource<List<Movie>> {
        return try {
            val movies = moviesRepository.getPopularMoviesAsync()
            if (movies.isEmpty()) return Resource.empty()
            Resource.success(movies)
        } catch (e: Exception) {
            Resource.error(e.message.toString())
        }
    }
}