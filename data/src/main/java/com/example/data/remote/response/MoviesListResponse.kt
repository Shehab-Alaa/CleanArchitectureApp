package com.example.data.remote.response

import com.example.data.model.MovieEntity
import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var movies: List<MovieEntity> = arrayListOf(),
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("total_results" )
    var totalResults : Int? = null
)