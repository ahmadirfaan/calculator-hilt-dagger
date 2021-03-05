package com.irfaan.calculator.data

import com.google.gson.annotations.SerializedName

data class CalculatorRequest(
    @SerializedName("number1") val number1 : Int,
    @SerializedName("number2") val number2 : Int,
    @SerializedName("operator") val operator :String
) {
}