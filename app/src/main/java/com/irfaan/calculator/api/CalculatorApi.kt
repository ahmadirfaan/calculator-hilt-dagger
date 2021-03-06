package com.irfaan.calculator.api

import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CalculatorApi {

    @POST("calculator")
    suspend fun calculate(@Body calculate: CalculatorRequest): Response<CalculatorResponse>
}