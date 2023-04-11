package com.example.searchspotapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("city/?format=json")
    fun getCities(): Call<List<CityModel>>

    companion object{
        var retrofitService:RetrofitService? = null
        fun getInstance():RetrofitService{
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://dev.urbanaut.in/api/v1.4/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }


//    @GET("spot/approved/")
//    fun getSpots(
//        @Query("city") city: String,
//        @Query("format") format: String = "json"
//    ): Call<Spot>

}
