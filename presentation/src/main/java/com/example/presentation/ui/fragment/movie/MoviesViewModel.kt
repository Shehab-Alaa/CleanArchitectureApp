package com.example.presentation.ui.fragment.movie

import android.app.Application
import com.example.presentation.base.AndroidBaseViewModel
import com.example.presentation.model.MovieItem

class MoviesViewModel(app: Application) : AndroidBaseViewModel(app){

    val adapter = MoviesAdapter(::onAdapterItemClick)

    private fun onAdapterItemClick(item: MovieItem) {
        setValue(item)
    }
}