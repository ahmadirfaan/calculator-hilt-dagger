package com.irfaan.calculator.data

import com.google.gson.annotations.SerializedName

data class CalculatorRequest(
    @SerializedName("number1") val number1 : Double,
    @SerializedName("number2") val number2 : Double,
    @SerializedName("operator") val operator :String
) {
}