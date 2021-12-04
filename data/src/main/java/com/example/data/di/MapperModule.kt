package com.example.data.di

import com.example.data.mapper.MovieEntityMapper
import org.koin.dsl.module

val mapperModule = module {

    single { provideMovieEntityMapper() }
}

fun provideMovieEntityMapper() : MovieEntityMapper = MovieEntityMapper()