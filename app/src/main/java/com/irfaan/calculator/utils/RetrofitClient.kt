package com.irfaan.calculator.utils

import com.irfaan.calculator.api.CalculatorApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8081/"
    private val client = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    val service = retrofit.create(CalculatorApi::class.java)
}