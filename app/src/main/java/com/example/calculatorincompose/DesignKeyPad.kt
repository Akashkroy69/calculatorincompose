package com.example.calculatorincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorincompose.ui.theme.yellow
import com.example.calculatorincompose.ui.theme.yellowishWhite

//this will be used to design a keypad
@Composable
fun DesignKeyPad(
    state: CalculatorState,
    modifier: Modifier,
    buttonSpacing: Dp,
    onClickAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.firstInput + " " + (state.operator?.symbol
                    ?: "") + " " + state.secondInput,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.End,
                fontSize = 50.sp,
                maxLines = 2,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "CLEAR",
                    modifier = Modifier
                        .weight(2f)
                        .aspectRatio(2f)
                        .background(yellow),
                    onClick = {
                        onClickAction(CalculatorAction.Clear)
                    })
                DesignButton(
                    symbol = "Del",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        //onClickAction(CalculatorAction.Del)
                    })
                DesignButton(
                    symbol = "pow",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        //onClickAction(CalculatorAction.OperatorEntry(CalculatorOperator.Power))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "sin",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        /*  onClickAction(
                              CalculatorAction.TrigonometricCalculation(
                                  TrigonometricFunctions.Sin
                              )
                          )*/

                    })
                DesignButton(
                    symbol = "cos",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        /* onClickAction(
                             CalculatorAction.TrigonometricCalculation(
                                 TrigonometricFunctions.Cos
                             )
                         )*/
                    })
                DesignButton(
                    symbol = "tan",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        /* onClickAction(
                             CalculatorAction.TrigonometricCalculation(
                                 TrigonometricFunctions.Tan
                             )
                         )*/
                    })
                DesignButton(
                    symbol = "/",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        // onClickAction(CalculatorAction.OperatorEntry(CalculatorOperator.Division))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "7",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(7))
                    })
                DesignButton(
                    symbol = "8",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(8))
                    })
                DesignButton(
                    symbol = "9",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(9))
                    })
                DesignButton(
                    symbol = "x",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        onClickAction(CalculatorAction.OperatorEntry(CalculatorOperator.Multiplication))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "4",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(4))
                    })
                DesignButton(
                    symbol = "5",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(5))
                    })
                DesignButton(
                    symbol = "6",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(6))
                    })
                DesignButton(
                    symbol = "-",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        // onClickAction(CalculatorAction.OperatorEntry(CalculatorOperator.Subtraction))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "1",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(1))
                    })
                DesignButton(
                    symbol = "2",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(2))
                    })
                DesignButton(
                    symbol = "3",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(3))
                    })
                DesignButton(
                    symbol = "+",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        //  onClickAction(CalculatorAction.OperatorEntry(CalculatorOperator.Addition))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                DesignButton(
                    symbol = "0",
                    modifier = Modifier
                        .weight(2f)
                        .aspectRatio(2f)
                        .background(yellowishWhite),
                    onClick = {
                        onClickAction(CalculatorAction.NumberEntry(0))
                    })
                DesignButton(
                    symbol = ".",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellowishWhite),
                    onClick = {
                        //   onClickAction(CalculatorAction.Decimal)
                    })
                DesignButton(
                    symbol = "=",
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(yellow),
                    onClick = {
                        // onClickAction(CalculatorAction.Calculate)
                    })
            }


        }

    }

}