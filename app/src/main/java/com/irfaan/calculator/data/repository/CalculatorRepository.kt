package com.irfaan.calculator.data.repository

import com.irfaan.calculator.data.models.CalculatorRequest
import com.irfaan.calculator.data.models.CalculatorResponse
import retrofit2.Response

interface CalculatorRepository {
    suspend fun calculate(calculate: CalculatorRequest): Response<CalculatorResponse>
}