package com.example.advanced_calculator_app

data class CalculatorState(
    val number1: String = "", //This will take in first number in String format
    val number2: String = "", //This will take the second number in String format
    val operation: CalculatorOperation? = null //This will take the operation


)
