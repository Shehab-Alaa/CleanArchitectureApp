package com.example.presentation.ui

import com.example.domain.model.Movie
import com.example.domain.usecase.Resource
import com.example.domain.usecase.movie.GetMoviesUseCase
import com.example.presentation.base.BaseViewModelTest
import com.example.presentation.mapper.MovieItemMapper
import com.example.presentation.model.generateErrorMessage
import com.example.presentation.model.generateMoviesList
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest : BaseViewModelTest(){

    private var moviesUseCase: GetMoviesUseCase = mockk()

    private lateinit var moviesViewModel: MoviesViewModel
    private val movieItemMapper = MovieItemMapper()

    override fun setup() {
        super.setup()
        moviesViewModel = MoviesViewModel(moviesUseCase,movieItemMapper)
    }

    @Test
    fun `get Movies List`  (){

        val moviesList = generateMoviesList()
        val expectedMovieItems = moviesList.map { movieItemMapper.mapToPresentation(it) }

        coEvery { moviesUseCase.executeAsync() } returns Resource.success(moviesList)

        moviesViewModel.getPopularMoviesAsync()

        moviesViewModel.resultLiveData.observeForever {
            assertEquals(Resource.success(expectedMovieItems),it)
        }
        moviesViewModel.movieItemsLiveData.observeForever {
            assertEquals(expectedMovieItems,it)
        }
    }

    @Test
    fun `get Empty List`  (){

        coEvery { moviesUseCase.executeAsync() } returns Resource.empty()

        moviesViewModel.getPopularMoviesAsync()

        moviesViewModel.resultLiveData.observeForever {
            assertEquals(Resource.empty<List<Movie>>(),it)
        }
    }

    @Test
    fun `get Movies Error`  (){

        val errorMessage = generateErrorMessage()

        coEvery { moviesUseCase.executeAsync() } returns Resource.error(errorMessage)

        moviesViewModel.getPopularMoviesAsync()

        moviesViewModel.resultLiveData.observeForever {
            assertEquals(Resource.error<List<Movie>>(errorMessage),it)
        }
    }

}