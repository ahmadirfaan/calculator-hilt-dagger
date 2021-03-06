package com.irfaan.calculator

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.CalculatorResponse
import com.irfaan.calculator.data.repository.CalculatorRepositoryImpl
import com.irfaan.calculator.databinding.ActivityMainBinding
import com.irfaan.calculator.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
//AdapterView.OnItemSelectedListener
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private var operators = arrayListOf("ADDITION", "SUBTRACTION", "MULTIPLY", "DIVISION")
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        subscribe()
        binding.apply {
            buttonCalculate.setOnClickListener {
                val inputNumber1Double = inputNumber1.text.toString().toDouble()
                val inputNumber2Double = inputNumber2.text.toString().toDouble()
                val inputOperatorString = inputOperator.text.toString()
                val calRequest = CalculatorRequest(inputNumber1Double, inputNumber2Double, inputOperatorString)
                viewModel.onPostCalculate(calRequest)
                Log.i("INI BUTTON CALCULATE", "CLICK")
            }
        }
//        var spinner = findViewById<Spinner>(R.id.spinner)
//
//        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
//            this@MainActivity,
//            android.R.layout.simple_spinner_item, operators
//        )
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);

    }

//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        binding.apply {
//            when (position) {
//                0 -> {
//                    inputOperator.setText(operators[0])
//                }
//                1 -> {
//                    inputOperator.setText(operators[1])
//                }
//                2 -> {
//                    inputOperator.setText(operators[2])
//                }
//                3 -> {
//                inputOperator.setText(operators[3])
//                }
//            }
//        }
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        TODO("Not yet implemented")
//    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = CalculatorRepositoryImpl()
                return MainViewModel(repository) as T
            }

        }).get(MainViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.mutableStringData.observe(this, {
            binding.tvResponse.text = it
        })
    }
}