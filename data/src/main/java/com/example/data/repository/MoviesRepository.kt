package com.example.data.repository

import com.example.data.mapper.MovieMapper
import com.example.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository

class MoviesRepository(private val movieApi: MovieApi,private val movieMapper: MovieMapper) : IMoviesRepository {

    override suspend fun getPopularMoviesAsync(): List<Movie> {
        return movieApi.getPopularMoviesAsync().movies.map {
            movieMapper.mapToDomain(it)
        }
    }
}