package com.example.data.remote.api

import com.example.data.remote.response.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    companion object{
        const val keyMovie = "movie"
    }

    @GET("$keyMovie/popular")
    suspend fun getPopularMoviesAsync(@Query("page") page: Int): MoviesListResponse
}