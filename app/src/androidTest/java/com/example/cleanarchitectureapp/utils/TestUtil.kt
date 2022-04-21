package com.example.cleanarchitectureapp.utils

import android.content.Context
import com.example.data.mapper.MovieMapper
import com.example.data.model.MovieEntity
import com.example.domain.model.Movie
import com.example.domain.usecase.Resource
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object TestUtil {

    var resourceStatus: Resource<Any?> = Resource.loading()

    fun getErrorMessage() = "Network error, please try again!"

    fun getDummyMoviesData(app: Context) : List<Movie>{
        val jsonFileString = getJsonDataFromAsset(app)
        val gson = Gson()
        val listMoviesType = object : TypeToken<List<MovieEntity>>() {}.type
        val movies: List<MovieEntity> = gson.fromJson(jsonFileString, listMoviesType)
        val movieMapper = MovieMapper()
        return movies.map { movieMapper.mapToDomain(it) }
    }

    private fun getFileName() = "PopularMoviesResponse.json"

    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(getFileName()).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}