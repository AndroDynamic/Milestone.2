package com.example.mealprepproper

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MacroClient {

    val apiKey = "hoxLUH/lDvE1jG/hP6P8dw==Vp4iowEOsbSoXpPC"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HeaderInterceptor(apiKey))
        .build()

    val api = Retrofit.Builder()
        .baseUrl("https://api.calorieninjas.com/v1/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FoodApiService::class.java)

}
