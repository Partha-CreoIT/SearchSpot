package com.example.searchspot

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("city/?format=json")
    fun getCities(): Call<CityResponse>


    @GET("spot/approved/")
    fun getSpots(
        @Query("city") city: String,
        @Query("format") format: String = "json"
    ): Call<Spot>
    @GET("https://d10y46cwh6y6x1.cloudfront.net/")
    fun getImages(): Call<Spot>
}


