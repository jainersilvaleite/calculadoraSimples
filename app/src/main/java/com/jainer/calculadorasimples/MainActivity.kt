package com.jainer.calculadorasimples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jainer.calculadorasimples.data.AppNavigation
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraSimplesTheme {
                AppNavigation()
            }
        }
    }
}