package com.example.data.repository

import com.example.data.mapper.MovieMapper
import com.example.data.remote.api.MovieApi
import com.example.domain.model.Movie
import com.example.domain.repository.IMoviesRepository

class MoviesRepository(private val movieApi: MovieApi,private val movieMapper: MovieMapper) : IMoviesRepository {

    private var page: Int = 0
    private var totalPages: Int = 1

    override suspend fun getPopularMoviesAsync(): List<Movie> {
        if (page < totalPages) {
            page += 1
            val response = movieApi.getPopularMoviesAsync(page)
            response.totalPages?.let { totalPages = it }
            return response.movies.map {
                movieMapper.mapToDomain(it)
            }
        }
        return listOf()
    }

    override suspend fun getMoviesSearchAsync(query: String): List<Movie> {
        val response = movieApi.getMoviesSearchAsync(query)
        return response.movies.map {
            movieMapper.mapToDomain(it)
        }
    }
}