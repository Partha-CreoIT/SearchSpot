package com.example.searchspot

import android.util.Log
import retrofit2.Call


class CityRepo(private val retrofitService: ApiInterface) {
    fun getAllCity(): Call<CityResponse> {
        val citiesRes = retrofitService.getCities()
        Log.d("CityRepo", "$citiesRes")
        return citiesRes
    }
}