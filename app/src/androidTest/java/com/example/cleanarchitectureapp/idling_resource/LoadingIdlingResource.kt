package com.example.cleanarchitectureapp.idling_resource

import android.view.View
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.withFragment
import androidx.test.espresso.IdlingResource
import com.example.presentation.ui.MoviesFragment

class LoadingIdlingResource constructor(private val fragmentScenario: FragmentScenario<MoviesFragment>) : IdlingResource {

    private var resourceCallback: IdlingResource.ResourceCallback? = null

    override fun getName(): String {
        return "LoadingIdlingResource"
    }

    override fun isIdleNow(): Boolean {
        return if (!isProgressShowing()) {
            resourceCallback?.onTransitionToIdle()
            true
        } else {
            false
        }
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        resourceCallback = callback
    }

    private fun isProgressShowing(): Boolean {
        var isVisible = false
        fragmentScenario.withFragment {
            val progressBar = this.binding.progressBar
            isVisible = progressBar.visibility == View.VISIBLE
        }
        return isVisible
    }
}