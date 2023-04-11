package com.example.searchspot

import com.google.gson.annotations.SerializedName

data class Spot(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")val results: List<Result>
) {
    data class Result(
        val actual_image: String,
        val address: String,
        val categories: List<Int>,
        val categories_name: List<String>,
        val category: Int,
        val contributor: Contributor,
        val end: String,
        val google_place_id: String,
        val id: Int,
        val is_favourite: Boolean,
        val lat: Double,
        val lng: Double,
        val modified: String,
        val must_see: Boolean,
        val name: String,
        val photo: String,
        val slug: String,
        val spot: Int,
        val start: String,
        val timing: Any
    ) {
        data class Contributor(
            val age: Any,
            val city: String,
            val first_name: String,
            val gender: String,
            val id: Int,
            val instagram: String,
            val profile_picture: String,
            val short_bio: String
        )
    }
}