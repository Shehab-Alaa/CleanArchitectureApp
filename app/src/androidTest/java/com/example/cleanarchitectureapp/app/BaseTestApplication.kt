package com.example.cleanarchitectureapp.app

import android.app.Application
import com.example.cleanarchitectureapp.di.testDataModule
import com.example.data.di.mapperModule
import com.example.data.di.networkModule
import com.example.data.di.repositoriesModule
import com.example.presentation.di.presentationMapperModule
import com.example.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseTestApplication)
            modules(listOf(viewModelModule, repositoriesModule, networkModule, mapperModule, testDataModule, presentationMapperModule))
        }
    }
}