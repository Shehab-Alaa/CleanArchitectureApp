package com.example.data.di

import com.example.data.repository.MoviesRepository
import com.example.domain.repository.IMoviesRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single { provideMoviesRepository() }
}

fun provideMoviesRepository() : IMoviesRepository = MoviesRepository()