package com.example.mealprepproper

import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApiService {
    @GET("nutrition")
    suspend fun searchFoods(
        @Query("query") query: String
    ): FoodResponse
}