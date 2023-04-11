package com.example.searchspot

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface1 {
    @GET("spot/approved/")
    fun getSpots(
        @Query("city") city: String,
        @Query("format") format: String = "json"
    ): Call<Spot>

    companion object{
        var retrofitService1:ApiInterface? = null
        fun getInstance():ApiInterface{
            if (retrofitService1 == null){
                val retrofitBuilder = Retrofit.Builder()
                    .baseUrl("https://dev.urbanaut.in/api/v1.4/")
                    .addConverterFactory(GsonConverterFactory.create())
                val httpClient = OkHttpClient.Builder()
                if (!httpClient.interceptors().contains(LoggingInterceptor)) {
                    httpClient.addInterceptor(LoggingInterceptor)
                    retrofitBuilder.client(httpClient.build())

                }
                val retrofit = retrofitBuilder.build()
                retrofitService1 = retrofit.create(ApiInterface::class.java)
            }
            return retrofitService1!!
        }
    }
}