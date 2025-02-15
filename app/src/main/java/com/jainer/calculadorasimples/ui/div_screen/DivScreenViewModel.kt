package com.jainer.calculadorasimples.ui.div_screen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DivScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DivScreenUiState())
    val uiState: StateFlow<DivScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                onFirstNumberChange = { firstNumber ->
                    _uiState.value = _uiState.value.copy(
                        firstNumber = firstNumber
                    )
                },
                onSecondNumberChange = { secondNumber ->
                    _uiState.value = _uiState.value.copy(
                        secondNumber = secondNumber
                    )
                },
                changeResult = { result ->
                    _uiState.value = _uiState.value.copy(
                        result = result
                    )
                }
            )
        }
    }
}