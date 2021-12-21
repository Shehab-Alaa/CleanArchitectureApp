package com.example.data.repository

import com.example.data.mapper.MovieEntityMapper
import com.example.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository

class MoviesRepository(private val movieApi: MovieApi,private val movieEntityMapper: MovieEntityMapper) : IMoviesRepository {

    override suspend fun getPopularMoviesAsync(): List<Movie> {
        return movieApi.getPopularMoviesAsync().movies.map {
            movieEntityMapper.mapToDomain(it)
        }
    }
}