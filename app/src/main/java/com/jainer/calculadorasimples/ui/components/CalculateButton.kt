package com.jainer.calculadorasimples.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jainer.calculadorasimples.R
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun CalculateButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .width(150.dp)
            .height(40.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_hint),
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun SumScreenPreview() {
    CalculadoraSimplesTheme {
        CalculateButton(onClick = {})
    }
}