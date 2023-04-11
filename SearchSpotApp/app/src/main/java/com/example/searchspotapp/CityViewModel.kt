package com.example.searchspotapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityViewModel constructor(private val cityRepository: CityRepository) : ViewModel() {
    val cityList = MutableLiveData<List<CityModel>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCity(){
        val response = cityRepository.getAllCity()
        response.enqueue(object : Callback<List<CityModel>>{
            override fun onResponse(
                call: Call<List<CityModel>>,
                response: Response<List<CityModel>>
            ) {
                cityList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CityModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }


        })
    }
}