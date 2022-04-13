package com.example.cleanarchitectureapp.app

import com.example.cleanarchitectureapp.di.testDataModule
import org.koin.dsl.koinApplication

class BaseTestApplication: BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        koinApplication {
            modules(testDataModule)
        }
    }
}