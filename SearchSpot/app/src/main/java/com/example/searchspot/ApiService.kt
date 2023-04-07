package com.example.searchspot

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("city/?format=json")
    fun getCities(): Call<CityResponse>

    @GET("spot/approved/?city=Bengaluru&format=json")
    fun getSpot(): Call<Spot>

}