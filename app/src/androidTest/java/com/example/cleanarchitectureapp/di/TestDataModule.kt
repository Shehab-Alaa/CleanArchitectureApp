package com.example.cleanarchitectureapp.di

import android.app.Application
import com.example.cleanarchitectureapp.TestMoviesUseCase
import com.example.domain.repository.IMoviesRepository
import com.example.domain.usecase.movie.GetMoviesUseCase
import org.koin.dsl.module

val testDataModule = module {

    single { provideTestMoviesUseCase(get(),get()) }
}

fun provideTestMoviesUseCase(app: Application,
                             moviesRepository: IMoviesRepository
): GetMoviesUseCase = TestMoviesUseCase(app,moviesRepository)
