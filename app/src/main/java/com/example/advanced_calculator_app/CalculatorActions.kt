package com.example.advanced_calculator_app

//This class can be subclassed by only limited number of classes and it's extend feature is also limited
sealed class CalculatorActions{
    data class Number(val number:Int): CalculatorActions() //class Number extends class CalculatorActions
    object Clear: CalculatorActions() //Clear the screen
    object Delete: CalculatorActions() //Delete the last character
    object Decimal: CalculatorActions() //Add decimal point
    object Calculate: CalculatorActions() //Calculate the result
    data class Operation(val operation: CalculatorOperation): CalculatorActions() //Add operation
    
}
