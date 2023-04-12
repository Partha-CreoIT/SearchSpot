package com.example.searchspot.module

import com.example.searchspot.ApiInterface1
import com.example.searchspot.CityRepo
import com.example.searchspot.CityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { ApiInterface1 }
    single { CityRepo(get()) }
    viewModel{ CityViewModel(get()) }
}