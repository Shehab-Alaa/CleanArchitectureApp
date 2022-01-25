package com.example.cleanarchitectureapp.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.IdlingRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.cleanarchitectureapp.idling_resource.LoadingIdlingResource
import com.example.presentation.ui.MoviesFragment
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesFragmentInstrumentedTest {

    private lateinit var scenario: FragmentScenario<MoviesFragment>
    private lateinit var loadingIdlingResource: LoadingIdlingResource

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
        loadingIdlingResource = LoadingIdlingResource(scenario)
        IdlingRegistry.getInstance().register(loadingIdlingResource)
    }

    @Test
    fun testPopularMoviesData() {
        launchPopularMovies {
            verifyMovies()
        }
    }

    @After
    fun cleanUp() {
        IdlingRegistry.getInstance().unregister(loadingIdlingResource)
    }
}