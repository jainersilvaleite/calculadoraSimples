package com.jainer.calculadorasimples.ui.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jainer.calculadorasimples.R
import com.jainer.calculadorasimples.data.HomeOption
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun HomeOptionButton(
    onClick: () -> Unit,
    homeOption: HomeOption,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .width(110.dp)
            .height(100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(homeOption.image),
                contentDescription = stringResource(homeOption.name) + " Option",
                modifier = Modifier.size(50.dp)
            )
            Text(
                text = stringResource(homeOption.name),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeOptionButtonPreview() {
    CalculadoraSimplesTheme {
        HomeOptionButton(
            onClick = {},
            homeOption = HomeOption(
                name = R.string.homeOption_sum,
                image = R.drawable.operacao_somar
            )
        )
    }
}