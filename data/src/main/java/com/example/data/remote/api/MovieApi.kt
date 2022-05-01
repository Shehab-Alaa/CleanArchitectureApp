package com.example.data.remote.api

import com.example.data.remote.response.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    companion object{
        const val keyMovie = "movie"
        const val keySearch = "search"
    }

    @GET("$keyMovie/popular")
    suspend fun getPopularMoviesAsync(@Query("page") page: Int): MoviesListResponse

    @GET("$keySearch/$keyMovie")
    suspend fun getMoviesSearchAsync(@Query("query") query: String): MoviesListResponse
}