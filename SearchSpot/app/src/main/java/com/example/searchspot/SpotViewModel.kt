package com.example.searchspot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpotViewModel  constructor(private val spotRepo: SpotRepo) : ViewModel() {
    val spotList = MutableLiveData<List<Spot>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllSpots(){
        val response = spotRepo.getAllSpots()
        response.enqueue(object : Callback<Spot> {
            override fun onResponse(call: Call<Spot>, response: Response<Spot>) {
                spotList.postValue(response.body().)
            }

            override fun onFailure(call: Call<Spot>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }



}