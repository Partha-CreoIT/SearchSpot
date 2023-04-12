package com.example.searchspot.module

import com.example.searchspot.ApiInterface
import com.example.searchspot.CityRepo
import com.example.searchspot.CityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val viewModelModule = module {
        single { CityRepo(ApiInterface.retrofitService!!) }
        viewModel { CityViewModel(get()) }
}