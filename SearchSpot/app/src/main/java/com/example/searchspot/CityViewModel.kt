package com.example.searchspot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityViewModel constructor(private val cityRepo: CityRepo) : ViewModel() {
    val cityList = MutableLiveData<List<City>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCity() {
        val response = cityRepo.getAllCity()
        response.enqueue(object : Callback<CityResponse> {


            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                cityList.postValue(response.body()?.results)
            }

        }
        )

    }

}