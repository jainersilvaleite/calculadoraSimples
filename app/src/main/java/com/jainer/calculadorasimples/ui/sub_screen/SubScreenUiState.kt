package com.jainer.calculadorasimples.ui.sub_screen

data class SubScreenUiState(
    val firstNumber: String = "",
    val secondNumber: String = "",
    val result: Double = 0.0,
    val onFirstNumberChange: (String) -> Unit = {},
    val onSecondNumberChange: (String) -> Unit = {},
    val changeResult: (Double) -> Unit = {}
) {
    fun sub(firstNumber: String, secondNumber: String): Double {
        val firstNumberToDouble = firstNumber.replace(',', '.').toDouble()
        val secondNumberToDouble = secondNumber.replace(',', '.').toDouble()
        return firstNumberToDouble - secondNumberToDouble
    }
}