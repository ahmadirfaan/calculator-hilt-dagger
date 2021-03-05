package com.irfaan.calculator.api

import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CalculatorApi {

    @Headers("Content-Type: application/json")
    @POST("calculator")
    fun calculate(@Body calculate : CalculatorRequest) : Call<CalculatorResponse>
}