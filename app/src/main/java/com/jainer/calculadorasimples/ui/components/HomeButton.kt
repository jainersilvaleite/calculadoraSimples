package com.jainer.calculadorasimples.ui.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jainer.calculadorasimples.data.Routes
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun HomeButton(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { navController.popBackStack(route = Routes.homeScreen, inclusive = false) },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = CircleShape,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = Routes.homeScreen,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeButtonPreview() {
    CalculadoraSimplesTheme {
        HomeButton(rememberNavController())
    }
}