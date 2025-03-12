package com.example.advanced_calculator_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {

    var myState: MutableState<CalculatorState> = mutableStateOf(CalculatorState())
        private set
    fun onAction(actions: CalculatorActions){
        when(actions){
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Clear -> myState.value = CalculatorState()
            is CalculatorActions.Delete -> delete()
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Calculate -> calculate()
            is CalculatorActions.Operation -> enterOperation(actions.operation)

        }
    }

    private fun enterNumber(i: Int) {
        if(myState.value.operation == null){
            if(myState.value.number1.length >= MAX_NUM_LENGTH){
                return
            }
            myState.value = myState.value.copy(
                number1 = myState.value.number1 + i
            )
            return
        }
        if(myState.value.number2.length >= MAX_NUM_LENGTH){
            return
        }
        myState.value = myState.value.copy(
            number2 = myState.value.number2 + i
        )
    }
    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
    private fun enterOperation(operation: CalculatorOperation) {
        if(myState.value.number1.isNotBlank()){
            myState.value = myState.value.copy(operation = operation)
        }
    }
    private fun calculate() {
        val number1 = myState.value.number1.toDoubleOrNull()
        val number2 = myState.value.number2.toDoubleOrNull()
        if(number1 != null && number2 != null){
            val result = when(myState.value.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return

            }
            myState.value = myState.value.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }
    private fun enterDecimal() {
        if(myState.value.operation == null && !myState.value.number1.contains(".")
            && myState.value.number1.isNotBlank()
        ){
            myState.value = myState.value.copy(
                number1 = myState.value.number1 + "."
            )
            return
        }
        if(!myState.value.number2.contains(".") && myState.value.number2.isNotBlank()
        ) {
            myState.value = myState.value.copy(
                number2 = myState.value.number2 + "."
            )
        }
    }
    private fun delete() {
        when{
            myState.value.number2.isNotBlank() -> myState.value = myState.value.copy(
                number2 = myState.value.number2.dropLast(1)
            )
            myState.value.operation != null -> myState.value = myState.value.copy(
                operation = null
            )
            myState.value.number1.isNotBlank() -> myState.value = myState.value.copy(
                number1 = myState.value.number1.dropLast(1)
            )
        }
    }
}