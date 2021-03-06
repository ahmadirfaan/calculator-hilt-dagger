package com.irfaan.calculator.data.repository

import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import retrofit2.Response
import retrofit2.http.Body

interface CalculatorRepository {
    suspend fun calculate(calculate: CalculatorRequest): Response<CalculatorResponse>
}