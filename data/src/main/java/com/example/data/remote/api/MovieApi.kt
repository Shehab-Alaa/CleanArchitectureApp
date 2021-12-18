package com.example.data.remote.api

import com.example.data.remote.response.MoviesListResponse
import retrofit2.http.GET

interface MovieApi {

    companion object{
        const val keyMovie = "movie"
    }

    @GET("$keyMovie/popular")
    suspend fun getPopularMoviesAsync(): MoviesListResponse
}