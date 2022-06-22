package com.example.calculatorincompose

//this sealed class has all the events/actions and data classes integrated with buttons
sealed class CalculatorAction {
    //following are just events and there is no data involved with the events.
    object Clear : CalculatorAction()
    object Del : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal : CalculatorAction()

    //following are events and there are some data involved with the events. i.e, the event's nature depends on
    // some kind of data and we have to pass the events with specific data. so we will make
    //data classes that are eventually type of the event class, CalculatorAction and in the constructor of the data class
    //we will define the type of data that has to be passed.
    data class NumberEntry(val number: Int) : CalculatorAction()
    data class OperatorEntry(val operator: CalculatorOperator) : CalculatorAction()
    data class TrigonometricCalculation(val trigonometricFunction: TrigonometricFunctions) :
        CalculatorAction()
}
