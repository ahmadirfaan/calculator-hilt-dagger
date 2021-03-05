package com.irfaan.calculator

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import com.irfaan.calculator.databinding.ActivityMainBinding
import com.irfaan.calculator.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding : ActivityMainBinding
    private var operators = arrayListOf("ADDITION", "SUBTRACTION", "MULTIPLY", "DIVISION")
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
        var spinner = findViewById<Spinner>(R.id.spinner)

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this@MainActivity,
            android.R.layout.simple_spinner_item, operators
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        binding.apply {
            when (position) {
                0 -> {
                    inputOperator.setText(operators[0])
                }
                1 -> {
                    inputOperator.setText(operators[1])
                }
                2 -> {
                    inputOperator.setText(operators[2])
                }
                3 -> {
                inputOperator.setText(operators[3])
                }
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun doCalculate() {
        Log.i("INI fungsi doCALCULATE", "MASUK")
        var calculatorRequest : CalculatorRequest
        binding.apply {
            val number1String = inputNumber1.text.toString().toDouble()
            val number2String = inputNumber2.text.toString().toDouble()
            val operatorString = inputOperator.text.toString().toUpperCase()
            calculatorRequest = CalculatorRequest(number1String, number2String, operatorString)
        }
        RetrofitClient.service.calculate(calculatorRequest).enqueue(object :
            Callback<CalculatorResponse> {
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