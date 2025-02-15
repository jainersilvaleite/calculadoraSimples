package com.jainer.calculadorasimples.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HomeOption(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val route: String = Routes.homeScreen
)
