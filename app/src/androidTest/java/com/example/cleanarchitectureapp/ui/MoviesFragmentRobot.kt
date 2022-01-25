package com.example.cleanarchitectureapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.cleanarchitectureapp.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not

fun launchPopularMovies(func: MoviesFragmentRobot.() -> Unit) = MoviesFragmentRobot().apply { func() }
class MoviesFragmentRobot {

    fun verifyMovies() {
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
    }

    fun verifyEmpty(){
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_empty_view)).check(matches(isDisplayed()))
    }
}