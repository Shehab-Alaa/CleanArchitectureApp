package com.example.domain.repository

import com.example.domain.model.Movie

interface IMoviesRepository : Repository {

    suspend fun getPopularMoviesAsync(): List<Movie>
}