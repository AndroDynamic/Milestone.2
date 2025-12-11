package com.example.mealprepproper

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithHeaders = originalRequest.newBuilder()
            .header("X-Api-Key", apiKey)
            // .header("Accept", "application/json")
            .build()
        return chain.proceed(requestWithHeaders)
    }
}