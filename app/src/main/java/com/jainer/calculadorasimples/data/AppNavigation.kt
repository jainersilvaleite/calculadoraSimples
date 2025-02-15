package com.jainer.calculadorasimples.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jainer.calculadorasimples.ui.div_screen.DivScreen
import com.jainer.calculadorasimples.ui.home_screen.HomeScreen
import com.jainer.calculadorasimples.ui.multi_screen.MultiScreen
import com.jainer.calculadorasimples.ui.sub_screen.SubScreen
import com.jainer.calculadorasimples.ui.sum_screen.SumScreen

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.homeScreen
    ) {
        composable(Routes.homeScreen) {
            HomeScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Routes.sumScreen) {
            SumScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Routes.subScreen) {
            SubScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Routes.multiScreen) {
            MultiScreen(
                navController = navController,
                modifier = modifier
            )
        }
        composable(Routes.divScreen) {
            DivScreen(
                navController = navController,
                modifier = modifier
            )
        }
    }
}