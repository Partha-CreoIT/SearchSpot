package com.example.searchspot

import android.util.Log
import retrofit2.Call

class SpotRepo(private val retrofitService1: ApiInterface1) {

    fun getAllSpots() : Call<Spot> {
        val spotRes = retrofitService1.getSpots("city","json")
        Log.d("CityRepo", "$spotRes")
        return spotRes

    }

}