package com.example.presentation.di

import com.example.presentation.mapper.MovieMapper
import org.koin.dsl.module

val presentationMapperModule = module {

    single { provideMovieItemMapper() }
}

fun provideMovieItemMapper() : MovieMapper = MovieMapper()