package com.jainer.calculadorasimples.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jainer.calculadorasimples.R
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun NumbersBox(
    firstNumber: String,
    secondNumber: String,
    onFirstNumberChange: (String) -> Unit,
    onSecondNumberChange: (String) -> Unit,
    @DrawableRes operationIcon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.width(250.dp)
    ) {
        OutlinedTextField(
            value = firstNumber,
            onValueChange = { onFirstNumberChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.width(100.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Image(
            painter = painterResource(operationIcon),
            contentDescription = stringResource(R.string.homeOption_sum) + " Option",
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier.width(20.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        OutlinedTextField(
            value = secondNumber,
            onValueChange = { onSecondNumberChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier.width(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NumbersBoxPreview() {
    CalculadoraSimplesTheme {
        NumbersBox(
            firstNumber = "",
            secondNumber = "",
            onFirstNumberChange = {},
            onSecondNumberChange = {},
            operationIcon = R.drawable.operacao_somar
        )
    }
}