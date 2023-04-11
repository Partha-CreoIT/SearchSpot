package com.example.searchspotapp

import com.google.gson.annotations.SerializedName

data class CityModel(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<City>
)

data class City(
    @SerializedName("id") val id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("state") val state: String
)