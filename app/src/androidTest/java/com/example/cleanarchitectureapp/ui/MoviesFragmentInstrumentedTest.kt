package com.example.cleanarchitectureapp.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.cleanarchitectureapp.R
import com.example.cleanarchitectureapp.utils.TestUtil.getErrorMessage
import com.example.cleanarchitectureapp.utils.TestUtil.resourceStatus
import com.example.cleanarchitectureapp.utils.ToastMatcher
import com.example.domain.usecase.Resource
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesFragmentInstrumentedTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun testMoviesData() {
        resourceStatus = Resource.success()

        mActivityTestRule.launchActivity(null)

        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun testEmptyView(){
        resourceStatus = Resource.empty()

        mActivityTestRule.launchActivity(null)

        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_empty_view)).check(matches(isDisplayed()))
    }

    @Test
    fun testErrorMessage(){
        resourceStatus = Resource.error(getErrorMessage())

        mActivityTestRule.launchActivity(null)

        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
        onView(ViewMatchers.withText(getErrorMessage())).inRoot(ToastMatcher()).check(matches(isDisplayed()))
    }
}