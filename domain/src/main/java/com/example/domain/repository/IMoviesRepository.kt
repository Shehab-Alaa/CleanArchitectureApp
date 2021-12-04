package com.example.domain.repository

import com.example.domain.model.Movie
import io.reactivex.Single

interface IMoviesRepository : Repository {

    fun getPopularMoviesAsync(): Single<List<Movie>>
}