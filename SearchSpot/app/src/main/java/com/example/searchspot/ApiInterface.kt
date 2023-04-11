package com.example.searchspot

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("city/?format=json")
    fun getCities(): Call<CityResponse>

    companion object{
        var retrofitService:ApiInterface? = null
        fun getInstance():ApiInterface{
            if (retrofitService == null){
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl("https://dev.urbanaut.in/api/v1.4/")
                    .addConverterFactory(GsonConverterFactory.create())
                val httpClient = OkHttpClient.Builder()
                if (!httpClient.interceptors().contains(LoggingInterceptor)) {
                    httpClient.addInterceptor(LoggingInterceptor)
                    retrofitBuilder.client(httpClient.build())

                }
                val retrofit = retrofitBuilder.build()
                retrofitService = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService!!
        }
    }
}