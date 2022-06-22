package com.example.calculatorincompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

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
        TODO("Not yet implemented")
    }

    private fun performTrigonometricCalculation(trigonometricFunction: TrigonometricFunctions) {

    }

    private fun enterDecimal() {
        TODO("Not yet implemented")
    }

    private fun performDeletion() {
        TODO("Not yet implemented")
    }

    private fun enterOperator(operator: CalculatorOperator) {

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