package com.example.serialization.assignment

import com.google.gson.Gson
import java.net.URL

fun main(args:Array<String>) {
    var response = URL("https://dev.urbanaut.in/api/v1.4/city/?format=json").readText()
    var gson = Gson().fromJson(response,Result::class.java)


}