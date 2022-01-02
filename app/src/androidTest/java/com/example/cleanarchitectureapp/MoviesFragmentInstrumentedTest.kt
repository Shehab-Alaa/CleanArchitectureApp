package com.example.cleanarchitectureapp

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
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
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesFragmentInstrumentedTest {

    private lateinit var viewModel: MoviesViewModel
    private lateinit var scenario: FragmentScenario<MoviesFragment>
    private val resultLiveData = MutableLiveData<Resource<Any?>?>()
    private val movieItemsLiveData = MutableLiveData<List<MovieItem>>()

    @Before
    fun setUp() {
        // Mock our View Model to stub out calls later
        viewModel = mockk()
        // Stub out so we have control over LiveData's value
        every { viewModel.resultLiveData } returns resultLiveData
        every { viewModel.movieItemsLiveData } returns movieItemsLiveData
    }

    @Test
    fun getPopularMovies_LoadingState() {

        resultLiveData.postValue(Resource.loading())

        scenario = launchFragmentInContainer()

        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }

    @Test
    fun getPopularMovies_DataState() {

    }

    @Test
    fun getPopularMovies_EmptyState() {

        resultLiveData.postValue(Resource.empty())

        scenario = launchFragmentInContainer()

        onView(withId(R.id.tv_empty_view)).check(matches(isDisplayed()))
    }
}