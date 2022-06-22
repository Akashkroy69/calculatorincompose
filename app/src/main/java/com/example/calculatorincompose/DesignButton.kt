package com.example.calculatorincompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

//this will be used by DesignKeyPad composable to design a button
@Composable
fun DesignButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit,
    textStyle: TextStyle = TextStyle(),
    color: Color = Color.Black
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            //here we are assigning a generic event/listener onClick that will be attached with a real action event in the KeyPad
            //Composable.
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            style = textStyle,
            fontSize = 20.sp,
            color = color
        )
    }
}