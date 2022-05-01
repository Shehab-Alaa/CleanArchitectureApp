package com.example.presentation.di

import com.example.presentation.ui.movie.MoviesViewModel
import com.example.presentation.ui.search.MoviesSearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MoviesViewModel(get(),get()) }
    viewModel { MoviesSearchViewModel(get(),get()) }
}