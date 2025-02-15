package com.jainer.calculadorasimples.ui.sum_screen

data class SumScreenUiState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val result: Double = 0.0,
    val onFirstNumberChange: (String) -> Unit = {},
    val onSecondNumberChange: (String) -> Unit = {},
    val changeResult: (Double) -> Unit = {}
) {
    fun sum(firstNumber: String, secondNumber: String): Double {
        val firstNumberToDouble = firstNumber.replace(',', '.').toDouble()
        val secondNumberToDouble = secondNumber.replace(',', '.').toDouble()
        return firstNumberToDouble + secondNumberToDouble
    }
}