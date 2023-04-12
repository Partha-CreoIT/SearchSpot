package com.example.searchspot

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MySpotModel constructor(private val repository: SpotRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SpotViewModel::class.java)){
            SpotViewModel(this.repository) as T
        }
        else{
            throw  java.lang.IllegalArgumentException("View Model Not Found")
        }
    }
}