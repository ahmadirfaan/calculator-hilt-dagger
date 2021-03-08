package com.irfaan.calculator.data.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

class CalculatorResponse(
    @Json(name = "number1") val number1 : Double,
    @Json(name = "number2") val number2 : Double,
    @Json(name = "operator")val operator :String,
    @Json(name = "result") val result : Double
) {

}
