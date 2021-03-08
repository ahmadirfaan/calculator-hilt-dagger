package com.irfaan.calculator.data.api

import com.irfaan.calculator.data.models.CalculatorRequest
import com.irfaan.calculator.data.models.CalculatorResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CalculatorApi {

    @POST("calculator")
    suspend fun calculate(@Body calculate: CalculatorRequest): Response<CalculatorResponse>
}