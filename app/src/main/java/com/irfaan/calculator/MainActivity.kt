package com.irfaan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import com.irfaan.calculator.databinding.ActivityMainBinding
import com.irfaan.calculator.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            buttonCalculate.setOnClickListener {
                Log.i("INI BUTTON CALCULATE", "CLICK")
                doCalculate()
            }
        }
    }

    private fun doCalculate() {
        Log.i("INI fungsi doCALCULATE", "MASUK")
        var calculatorRequest : CalculatorRequest
        binding.apply {
            val number1String = inputNumber1.text.toString().toInt()
            val number2String = inputNumber2.text.toString().toInt()
            val operatorString = inputOperator.text.toString().toUpperCase()
            calculatorRequest = CalculatorRequest(number1String, number2String, operatorString)
        }
        RetrofitClient.service.calculate(calculatorRequest).enqueue(object : Callback<CalculatorResponse> {
            override fun onResponse(
                call: Call<CalculatorResponse>,
                response: Response<CalculatorResponse>
            ) {
                Log.d("INI RESPONSE CODE POST COBA DONG", "${response.body().toString()}")
                Log.i("INI RESPONSE CODE POST COBA DONG", "${response.body().toString()}")
                if (response.isSuccessful) {
                    val stringbuilder = """
                        Number 1 : ${response.body()?.number1},
                        Number 2 : ${response.body()?.number2},
                        Operator : ${response.body()?.operator},
                        Result : ${response.body()?.result}
                    """.trimIndent()
                    binding.tvResponse.text = stringbuilder
                } else {
                    Log.i("INI RESPONSE CODE POST COBA DONG", "${response.body()}")
                }
            }

            override fun onFailure(call: Call<CalculatorResponse>, t: Throwable) {
                binding.tvResponse.text = t.message
            }

        })
        Log.i("INI fungsi doCALCULATE AKHIR", "MASUK")

    }
}