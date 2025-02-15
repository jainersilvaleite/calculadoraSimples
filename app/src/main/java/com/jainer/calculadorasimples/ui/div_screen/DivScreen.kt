package com.jainer.calculadorasimples.ui.div_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jainer.calculadorasimples.R
import com.jainer.calculadorasimples.data.WindowSize
import com.jainer.calculadorasimples.data.WindowType
import com.jainer.calculadorasimples.data.rememberWindowSize
import com.jainer.calculadorasimples.ui.components.CalculateButton
import com.jainer.calculadorasimples.ui.components.HeaderText
import com.jainer.calculadorasimples.ui.components.HomeButton
import com.jainer.calculadorasimples.ui.components.NormalText
import com.jainer.calculadorasimples.ui.components.NumbersBox
import com.jainer.calculadorasimples.ui.components.ResultBox
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun DivScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val windowSize: WindowSize = rememberWindowSize()

    when(windowSize.width) {
        WindowType.Compact -> {
            CompactDivScreen(
                navController = navController,
                modifier = modifier
            )
        }
        else -> {
            MediumToExpandedDivScreen(
                navController = navController,
                modifier = modifier
            )
        }
    }
}

@Composable
fun CompactDivScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DivScreenViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val firstNumber = uiState.firstNumber
    val secondNumber = uiState.secondNumber
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HomeButton(navController = navController)
        Spacer(modifier = Modifier.height(50.dp))
        HeaderText(text = stringResource(R.string.homeOption_div))
        NormalText(text = stringResource(R.string.numbersBox_hint))
        Spacer(modifier = Modifier.height(20.dp))
        NumbersBox(
            firstNumber = firstNumber,
            secondNumber = secondNumber,
            onFirstNumberChange = { firstNumber -> uiState.onFirstNumberChange(firstNumber) },
            onSecondNumberChange = { secondNumber -> uiState.onSecondNumberChange(secondNumber) },
            operationIcon = R.drawable.operacao_dividir
        )
        Spacer(modifier = Modifier.height(20.dp))
        CalculateButton(
            onClick = {
                uiState.changeResult(
                    uiState.div(firstNumber, secondNumber)
                )
            }
        )
        Spacer(modifier = Modifier.height(50.dp))
        ResultBox(result = uiState.result)
    }
}

@Composable
fun MediumToExpandedDivScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DivScreenViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

    val firstNumber = uiState.firstNumber
    val secondNumber = uiState.secondNumber
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeButton(navController = navController)
            HeaderText(text = stringResource(R.string.homeOption_div))
        }
        Spacer(modifier = Modifier.width(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NormalText(text = stringResource(R.string.numbersBox_hint))
            NumbersBox(
                firstNumber = firstNumber,
                secondNumber = secondNumber,
                onFirstNumberChange = { firstNumber -> uiState.onFirstNumberChange(firstNumber) },
                onSecondNumberChange = { secondNumber -> uiState.onSecondNumberChange(secondNumber) },
                operationIcon = R.drawable.operacao_dividir
            )
            Spacer(modifier = Modifier.height(20.dp))
            CalculateButton(
                onClick = {
                    uiState.changeResult(
                        uiState.div(firstNumber, secondNumber)
                    )
                }
            )
        }
        Spacer(modifier = Modifier.width(50.dp))
        ResultBox(result = uiState.result)
    }
}

@Preview
@Composable
fun DivScreenPreview() {
    CalculadoraSimplesTheme {
        DivScreen(rememberNavController())
    }
}