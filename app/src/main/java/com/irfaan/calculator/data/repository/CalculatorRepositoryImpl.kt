package com.irfaan.calculator.data.repository

import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import com.irfaan.calculator.utils.RetrofitClient
import retrofit2.Response

class CalculatorRepositoryImpl : CalculatorRepository {
    override suspend fun calculate(request: CalculatorRequest): Response<CalculatorResponse> = RetrofitClient.postCalculate().calculate(request)

}