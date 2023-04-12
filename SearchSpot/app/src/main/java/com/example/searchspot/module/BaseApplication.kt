package com.example.searchspot.module

import android.app.Application
import com.example.searchspot.di.apiModule
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(apiModule, appModule, viewModelModule)
        }
    }
}