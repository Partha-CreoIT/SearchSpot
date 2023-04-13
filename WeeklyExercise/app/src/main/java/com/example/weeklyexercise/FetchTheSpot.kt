package com.example.weeklyexercise

import com.google.gson.Gson
import java.net.URL

data class CityResponse(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
) {
    data class Result(
        val country: Int,
        val id: Int,
        val is_public: Boolean,
        val lat: String,
        val lng: String,
        val location: String,
        val name: String,
        val order: Int,
        val place_id: String
    )
}


data class SpotResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Spot>
)

data class Spot(val id: Int, val name: String, val city: String, val description: String)

fun main() {
    val gson = Gson()
    val cityUrl = "https://dev.urbanaut.in/api/v1.4/city/?format=json"
    val cityResponse = gson.fromJson(URL(cityUrl).readText(), CityResponse::class.java)

    println("Available Cities Are :")

    val cities = cityResponse.results
    cities.forEach { println(it.name) }
    print("Enter the name of the city you want to see the spots for :")
    val selectedCityName = readLine()?.trim() ?: return
    val selectedCity = cities.find { it.name.equals(selectedCityName, ignoreCase = true) } ?: return

    val spotUrl = "https://dev.urbanaut.in/api/v1.4/spot/approved/?city=Bengaluru&format=json"
    val spotResponse = gson.fromJson(URL(spotUrl).readText(), SpotResponse::class.java)

    println("Spots in ${selectedCity.name} :")
    spotResponse.results.forEach { println("- ${it.name}") }

}