package com.example.cleanarchitectureapp.app

import android.app.Application
import com.example.data.di.mapperModule
import com.example.data.di.networkModule
import com.example.data.di.repositoriesModule
import com.example.presentation.di.presentationMapperModule
import com.example.presentation.di.useCaseModule
import com.example.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(listOf(viewModelModule, repositoriesModule, networkModule, mapperModule, useCaseModule, presentationMapperModule))
        }
    }

    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + "line: " + element.lineNumber
            }
        })
    }
}