package com.example.domain.usecase

import com.example.domain.model.generateEmptyMoviesList
import com.example.domain.model.generateMoviesList
import com.example.domain.model.getExceptionMessage
import com.example.domain.repository.MockMoviesRepository
import com.example.domain.usecase.movie.GetMoviesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GetMoviesUseCaseTest {

    @Test
    fun getPopularMoviesData(){

        val movieRepository = MockMoviesRepository()
        movieRepository.setDummyData(generateMoviesList())

        val getMoviesUseCase = GetMoviesUseCase(movieRepository)

        val expected = Resource.success(generateMoviesList())

        runBlocking {
            val result = getMoviesUseCase.executeAsync()
            assertEquals(expected, result)
        }
    }

    @Test
    fun getPopularMoviesEmptyData (){

        val movieRepository = MockMoviesRepository()
        movieRepository.setDummyData(generateEmptyMoviesList())

        val getMoviesUseCase = GetMoviesUseCase(movieRepository)

        val expected = Resource.empty<Any>()

        runBlocking {
            val result = getMoviesUseCase.executeAsync()
            assertEquals(expected, result)
        }
    }

    @Test
    fun getPopularMoviesNullData (){

        val movieRepository = MockMoviesRepository()
        movieRepository.setDummyData(null)

        val getMoviesUseCase = GetMoviesUseCase(movieRepository)

        runBlocking {
            val result = getMoviesUseCase.executeAsync()
            val expected = Resource.error<Any>(getExceptionMessage())
            assertEquals(expected,result)
        }
    }

}