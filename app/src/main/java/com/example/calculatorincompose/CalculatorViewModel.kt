package com.example.calculatorincompose

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

//the view model will have all the business logic for the operations
class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set   //<-- this line makes the state property from outside readable but unmodifiable.


    fun onClickAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.NumberEntry -> takeInputs(action.number)
            is CalculatorAction.OperatorEntry -> enterOperator(action.operator)
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Del -> performDeletion()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.TrigonometricCalculation -> performTrigonometricCalculation(action.trigonometricFunction)
            is CalculatorAction.Calculate -> performCalculation()
        }
    }

    private fun performCalculation() {
        Log.i("CALCULATE", "******")
        val firstInput = state.firstInput.toDoubleOrNull()
        val secondInput = state.secondInput.toDoubleOrNull()
        if (firstInput != null && secondInput != null) {
            Log.i("CALCULATE", "******")
            val result = when (state.operator) {
                is CalculatorOperator.Addition -> firstInput + secondInput
                is CalculatorOperator.Subtraction -> firstInput - secondInput
                is CalculatorOperator.Multiplication -> firstInput * secondInput
                is CalculatorOperator.Division -> firstInput / secondInput
                is CalculatorOperator.Power -> firstInput.pow(secondInput)
                null -> return
            }
            state = state.copy(
                firstInput = result.toString().take(15),
                secondInput = "",
                operator = null
            )

        }
    }

    private fun performTrigonometricCalculation(trigonometricFunction: TrigonometricFunctions) {
        Log.i("TRIG", " I reached here in trig fun")
        if (state.operator == null && state.secondInput.isBlank()) {
            val input = state.firstInput.toDoubleOrNull()
            if (input != null) {
                val result = when (trigonometricFunction) {
                    is TrigonometricFunctions.Sin -> sin(input)
                    is TrigonometricFunctions.Tan -> Math.tan(input)
                    is TrigonometricFunctions.Cos -> cos(input)
                }
                state = state.copy(
                    firstInput = "${trigonometricFunction.nameOfTrigFunction}(${state.firstInput}) = " + result.toString()
                        .take(7)
                )
            }

        }
    }

    private fun enterDecimal() {
        when {
            state.firstInput.isNotBlank() && state.operator == null && !state.firstInput.contains(".") -> state =
                state.copy(
                    firstInput = state.firstInput + "."
                )
            state.operator != null && state.secondInput.isNotBlank() && !state.firstInput.contains(".") -> state =
                state.copy(
                    secondInput = state.secondInput + "."
                )
        }
    }

    private fun performDeletion() {
        //when performs checking the condition in the written order and then it does not
        // check further if it finds a true statement.
        // So we have to write the code in that way.
        when {

            state.secondInput.isNotBlank() -> state = state.copy(
                secondInput = state.secondInput.dropLast(1)
            )
            state.operator != null -> state = state.copy(
                operator = null
            )
            state.firstInput.isNotBlank() -> state = state.copy(
                firstInput = state.firstInput.dropLast(1)
            )
        }
    }

    private fun enterOperator(operator: CalculatorOperator) {
        if (state.firstInput.isNotBlank()) {
            state = state.copy(
                operator = operator
            )
        }
    }

    private fun takeInputs(number: Int) {
        if (state.operator == null) {
            if (state.firstInput.length >= MAX_LENGTH) return

            state = state.copy(
                firstInput = state.firstInput + number
            )
            return
        }
        if (state.secondInput.length >= MAX_LENGTH) return
        state = state.copy(
            secondInput = state.secondInput + number
        )
        return
    }

    companion object {
        private const val MAX_LENGTH = 7
    }

}