
package com.example.datafetch.assignment
import com.fasterxml.jackson.module.kotlin.*
import com.example.datafetch.assignment.com.example.datafetch.assignment.Person
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


//val mapper = jacksonObjectMapper()
//
//
//fun main(args: Array<String>) {
//
//
//    var person: Person = mapper.readValue(URL("https://url-to-person.json"))
//    -> mapper.readValue(String)
//    -> mapper.readValue(URL)
//
//
//
//    person = mapper.readValue<Person>(URL("https://url-to-person.json"))
//    println(person.results)
//
//}
fun main() {
    val url = "https://dev.urbanaut.in/api/v1.4/city/?format=json"

    val request = Request.Builder().url(url).build()

    val client = OkHttpClient()
    client.newCall(request).execute()
}