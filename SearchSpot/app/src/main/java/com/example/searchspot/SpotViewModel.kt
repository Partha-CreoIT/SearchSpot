package com.example.searchspot


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpotViewModel  constructor(private val spotRepo: SpotRepo) : ViewModel() {
    val spotList = MutableLiveData<List<Spot.Result>>()
    val errorMessage = MutableLiveData<String>()
    private val _cityName = MutableLiveData<String>()
    val cityName: LiveData<String>
        get() = _cityName
    fun onCityClicked(cityName: String) {
        _cityName.value = cityName
    }

    fun getAllSpots(city:String){
        val response = spotRepo.getAllSpots(city)
        response.enqueue(object : Callback<Spot> {
            override fun onResponse(call: Call<Spot>, response: Response<Spot>) {
                spotList.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<Spot>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }



}