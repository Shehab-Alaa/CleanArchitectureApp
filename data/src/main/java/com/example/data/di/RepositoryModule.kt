package com.example.data.di

import com.example.data.mapper.MovieMapper
import com.example.data.remote.api.MovieApi
import com.example.data.repository.MoviesRepository
import com.example.domain.repository.IMoviesRepository
import org.koin.dsl.module

val repositoriesModule = module {

    single { provideMoviesRepository(get(),get()) }
}

fun provideMoviesRepository(
    movieApi: MovieApi,
    movieMapper: MovieMapper
): IMoviesRepository = MoviesRepository(movieApi,movieMapper)