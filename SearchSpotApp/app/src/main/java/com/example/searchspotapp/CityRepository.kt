package com.example.searchspotapp

class CityRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllCity() = retrofitService.getCities()
}