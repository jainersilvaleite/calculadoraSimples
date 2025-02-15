package com.jainer.calculadorasimples.ui.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jainer.calculadorasimples.R
import com.jainer.calculadorasimples.data.HomeOption
import com.jainer.calculadorasimples.data.HomeOptions
import com.jainer.calculadorasimples.data.WindowSize
import com.jainer.calculadorasimples.data.WindowType
import com.jainer.calculadorasimples.data.rememberWindowSize
import com.jainer.calculadorasimples.ui.components.HeaderText
import com.jainer.calculadorasimples.ui.theme.CalculadoraSimplesTheme

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val homeOptionsList = HomeOptions.getHomeOptionsList()
    val windowSize: WindowSize = rememberWindowSize()

    when(windowSize.width) {
        WindowType.Compact -> {
            CompactHomeScreen(
                navController = navController,
                homeOptionsList = homeOptionsList,
                modifier = modifier
            )
        }
        else -> {
            MediumToExpandedHomeScreen(
                navController = navController,
                homeOptionsList = homeOptionsList,
                modifier = modifier
            )
        }
    }
}

@Composable
fun CompactHomeScreen(
    navController: NavController,
    homeOptionsList: List<HomeOption>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HeaderText(text = stringResource(R.string.app_name))
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.width(250.dp)
        ) {
            items(homeOptionsList.size) { index ->
                val homeOption = homeOptionsList[index]
                HomeOptionButton(
                    onClick = { navController.navigate(homeOption.route) },
                    homeOption = homeOption,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        bottom = 10.dp
                    )
                )
            }
        }
    }
}

@Composable
fun MediumToExpandedHomeScreen(
    navController: NavController,
    homeOptionsList: List<HomeOption>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HeaderText(text = stringResource(R.string.app_name))
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.width(500.dp)
        ) {
            items(homeOptionsList.size) { index ->
                val homeOption = homeOptionsList[index]
                HomeOptionButton(
                    onClick = { navController.navigate(homeOption.route) },
                    homeOption = homeOption,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        bottom = 10.dp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    CalculadoraSimplesTheme {
        HomeScreen(rememberNavController())
    }
}