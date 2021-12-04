package com.example.data.remote.api

import com.example.data.remote.response.MoviesListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MovieApi {

    companion object{
        const val keyMovie = "movie"
    }

    @GET("$keyMovie/popular")
    fun getPopularMoviesAsync(): Single<MoviesListResponse>
}