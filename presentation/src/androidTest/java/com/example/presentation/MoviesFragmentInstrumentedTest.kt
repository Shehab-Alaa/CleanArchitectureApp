package com.example.presentation

import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.domain.usecase.Resource
import com.example.presentation.model.MovieItem
import com.example.presentation.ui.MoviesFragment
import com.example.presentation.ui.MoviesViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class MoviesFragmentInstrumentedTest {

    /*@Rule
    @JvmField
    val activityRule = ActivityScenarioRule(MainActivity::class.java)*/

    private lateinit var viewModel: MoviesViewModel
    private val moviesFragment = MoviesFragment()
    private val resultLiveData = MutableLiveData<Resource<Any?>?>()
    private val movieItemsLiveData = MutableLiveData<List<MovieItem>>()

    @Before
    fun setUp() {
        // Mock our View Model to stub out calls later
        viewModel = mock(MoviesViewModel::class.java)
        // Stub out so we have control over LiveData's value
        `when`(viewModel.resultLiveData).thenReturn(resultLiveData)
        `when`(viewModel.movieItemsLiveData).thenReturn(movieItemsLiveData)
    }

    @Test
    fun getPopularMovies_LoadingState() {
        /* Given */
        resultLiveData.postValue(Resource.loading())

        /* When */
        //activityRule.activity.setFragment(moviesFragment)

        /* Then */
        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }

    @Test
    fun getPopularMovies_DataState() {

    }

    @Test
    fun getPopularMovies_ErrorState() {

    }
}