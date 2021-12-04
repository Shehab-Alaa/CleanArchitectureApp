package com.example.data.repository

import com.example.data.mapper.MovieEntityMapper
import com.example.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository
import io.reactivex.Single

class MoviesRepository(private val movieApi: MovieApi,private val movieEntityMapper: MovieEntityMapper) : IMoviesRepository {

    override fun getPopularMoviesAsync(): Single<List<Movie>> {
        return movieApi.getPopularMoviesAsync().map { response ->
            response.movies.map { movieEntityMapper.mapToDomain(it) }
        }
    }
}