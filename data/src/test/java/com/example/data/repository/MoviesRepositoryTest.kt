package com.example.data.repository

import com.example.data.mapper.MovieEntityMapper
import com.example.data.model.generateMoviesList
import com.example.data.remote.api.MovieApi
import com.example.data.remote.response.MoviesListResponse
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MoviesRepositoryTest{

    private val movieApi : MovieApi = mockk()
    private val movieEntityMapper = MovieEntityMapper()
    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup() {
        moviesRepository = MoviesRepository(movieApi, movieEntityMapper)
    }

    @Test
    fun `Get Popular Movies Async` (){

        val moviesList = generateMoviesList()
        val moviesListResponse = MoviesListResponse(movies = moviesList)
        val expectedMovieItems = moviesList.map { movieEntityMapper.mapToDomain(it) }

        coEvery { movieApi.getPopularMoviesAsync() } returns moviesListResponse

        runBlocking {
            val result = moviesRepository.getPopularMoviesAsync()
            assertEquals(expectedMovieItems,result)
        }
    }

}