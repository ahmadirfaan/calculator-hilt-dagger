package com.irfaan.calculator.data.repository

import com.irfaan.calculator.data.api.CalculatorApi
import com.irfaan.calculator.data.models.CalculatorRequest
import com.irfaan.calculator.data.models.CalculatorResponse
import com.irfaan.calculator.utils.RetrofitClient
import retrofit2.Response
import javax.inject.Inject

class CalculatorRepositoryImpl
@Inject constructor(private val calculatorApi: CalculatorApi)
    : CalculatorRepository {
    override suspend fun calculate(request: CalculatorRequest) = calculatorApi.calculate(request)

}