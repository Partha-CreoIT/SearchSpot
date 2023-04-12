package com.example.searchspot.di

import com.example.searchspot.ApiInterface1
import com.example.searchspot.CityViewModel
import com.example.searchspot.LoggingInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { provideHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiInterface1(get()) }
    single { CityViewModel(get())}

}

private fun provideHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    if (!httpClient.interceptors().contains(LoggingInterceptor)) {
        httpClient.addInterceptor(LoggingInterceptor)
    }
    return httpClient.build()
}

private fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://dev.urbanaut.in/api/v1.4/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
}

private fun provideApiInterface1(retrofit: Retrofit): ApiInterface1 {
    return retrofit.create(ApiInterface1::class.java)
}
