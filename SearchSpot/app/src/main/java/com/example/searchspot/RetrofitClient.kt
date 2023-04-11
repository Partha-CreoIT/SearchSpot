package com.example.searchspot

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)

        val url = request.url.toString()
        val method = request.method
        val requestBody = request.body
        val responseBody = response.body

        Log.d("API", "URL: $url")
        Log.d("API", "Method: $method")
        if (requestBody != null) {
            val requestBodyString = requestBody.toString()
            Log.d("API", "Request Body: $requestBodyString")
        }
        if (responseBody != null) {
            val responseBodyString = responseBody.string()
            Log.d("API", "Response Body: $responseBodyString")
            val newResponseBody =
                ResponseBody.create(responseBody.contentType(), responseBodyString)
            return response.newBuilder().body(newResponseBody).build()
        }

        return response
    }
}