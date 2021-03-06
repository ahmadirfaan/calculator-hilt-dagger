package com.irfaan.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.irfaan.calculator.data.CalculatorRequest
import com.irfaan.calculator.data.repository.CalculatorRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository : CalculatorRepository) : ViewModel() {

    private var _mutableStringData = MutableLiveData<String>()
    val mutableStringData: LiveData<String>
        get() {
            return _mutableStringData
        }


    fun onPostCalculate(request : CalculatorRequest) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.calculate(request)
            if (response.isSuccessful) {
                response.body()?.let {
                    val stringbuilder = """
                        Number 1 : ${response.body()?.number1},
                        Number 2 : ${response.body()?.number2},
                        Operator : ${response.body()?.operator},
                        Result : ${response.body()?.result}
                    """.trimIndent()
                    _mutableStringData.postValue(stringbuilder)
                }
            } else {
                _mutableStringData.postValue("Error gaest sorry yah")
            }

        }
    }
}