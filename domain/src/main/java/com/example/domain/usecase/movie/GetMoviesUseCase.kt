package com.example.domain.usecase.movie

import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository
import com.example.domain.usecase.UseCase
import io.reactivex.Single

open class GetMoviesUseCase(
    private val moviesRepository: IMoviesRepository
) : UseCase<Single<List<Movie>>>(){

    override fun createObservable(): Single<List<Movie>> {
        return moviesRepository.getPopularMoviesAsync()
    }
}