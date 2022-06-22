package com.example.calculatorincompose

sealed class TrigonometricFunctions(val nameOfTrigFunction: String) {
    object Sin : TrigonometricFunctions("sin")
    object Tan : TrigonometricFunctions("tan")
    object Cos : TrigonometricFunctions("cos")
}
