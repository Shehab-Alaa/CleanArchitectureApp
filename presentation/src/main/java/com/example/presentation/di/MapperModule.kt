package com.example.presentation.di

import com.example.presentation.mapper.MovieItemMapper
import org.koin.dsl.module

val presentationMapperModule = module {

    single { provideMovieItemMapper() }
}

fun provideMovieItemMapper() : MovieItemMapper = MovieItemMapper()