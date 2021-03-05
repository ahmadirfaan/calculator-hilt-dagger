package com.irfaan.calculator.data

import com.google.gson.annotations.SerializedName

class CalculatorResponse(
    @SerializedName("number1") val number1 : Double,
    @SerializedName("number2") val number2 : Double,
    @SerializedName("operator") val operator :String,
    @SerializedName("result") val result : Double
) {

}
