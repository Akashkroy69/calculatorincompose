package com.example.calculatorincompose

data class CalculatorState(
    val firstInput : String = "",
    val secondInput : String = "",
    val operator : CalculatorOperator? = null
){

}
