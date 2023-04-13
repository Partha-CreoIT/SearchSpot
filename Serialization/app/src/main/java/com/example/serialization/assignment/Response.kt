package com.example.serialization.assignment

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("next")
	val next: Any? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null
)

data class ResultsItem(

	@field:SerializedName("country")
	val country: Int? = null,

	@field:SerializedName("lng")
	val lng: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("is_public")
	val isPublic: Boolean? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("place_id")
	val placeId: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null,

	@field:SerializedName("order")
	val order: Int? = null
)
