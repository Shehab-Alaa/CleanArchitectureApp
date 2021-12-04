package com.example.presentation.di

import com.example.presentation.ui.fragment.movie.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MoviesViewModel(get(),get()) }

}