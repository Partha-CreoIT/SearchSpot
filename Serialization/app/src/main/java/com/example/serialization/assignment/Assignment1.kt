package com.example.serialization.assignment

data class Assignment1(
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