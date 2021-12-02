package com.example.data.remote.api

import com.example.data.remote.response.MoviesListResponse
import retrofit2.http.GET
import kotlinx.coroutines.Deferred

interface MovieApi {

    companion object{
        const val keyMovie = "movie"
    }

    @GET("$keyMovie/popular")
    fun getPopularMoviesAsync(): Deferred<MoviesListResponse>
}