package com.example.data.di

import com.example.data.mapper.MovieMapper
import org.koin.dsl.module

val mapperModule = module {

    single { provideMovieEntityMapper() }
}

fun provideMovieEntityMapper() : MovieMapper = MovieMapper()