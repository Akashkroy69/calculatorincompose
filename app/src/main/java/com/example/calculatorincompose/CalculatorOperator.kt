package com.example.calculatorincompose

//this will hold the various operators
sealed class CalculatorOperator(val symbol: String) {
    //these are objects of type CalculatorOperator and will be assigned to operator property of CalculatorState.
    object Addition : CalculatorOperator("+")
    object Subtraction : CalculatorOperator("-")
    object Multiplication : CalculatorOperator("X")
    object Division : CalculatorOperator("/")
    object Power : CalculatorOperator("pow")
}
