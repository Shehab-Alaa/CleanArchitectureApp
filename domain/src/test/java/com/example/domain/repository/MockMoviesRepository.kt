package com.example.domain.repository

import com.example.domain.model.Movie

class MockMoviesRepository : IMoviesRepository {

    private var dummyData: List<Movie>? = null

    fun setDummyData(dummyData: List<Movie>?){
        this.dummyData = dummyData
    }

    override suspend fun getPopularMoviesAsync(): List<Movie> = dummyData!!
}