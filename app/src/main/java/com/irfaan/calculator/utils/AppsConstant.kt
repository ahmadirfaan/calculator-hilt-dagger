package com.irfaan.calculator.utils

import okhttp3.OkHttpClient

class AppsConstant {
    companion object {
        const val BASE_URL = "http://10.0.2.2:8081/"
        val client = OkHttpClient.Builder().build()
    }
}