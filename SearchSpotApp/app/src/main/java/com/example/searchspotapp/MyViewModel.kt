package com.example.searchspotapp


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MyViewModel constructor(private val repository: CityRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(CityViewModel::class.java)){
            CityViewModel(this.repository) as T
        }
        else{
            throw  java.lang.IllegalArgumentException("View Model Not Found")
        }
    }
}