package com.example.searchspot

import android.telecom.Call
import retrofit2.http.GET

interface ApiService {


    @GET("city/")
    suspend fun getCities(): CityResponse

}