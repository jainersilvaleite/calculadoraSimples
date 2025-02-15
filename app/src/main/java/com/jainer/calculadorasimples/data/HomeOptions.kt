package com.jainer.calculadorasimples.data

import com.jainer.calculadorasimples.R

object HomeOptions {
    fun getHomeOptionsList(): List<HomeOption> {
        return listOf(
            HomeOption(name = R.string.homeOption_sum, image = R.drawable.operacao_somar, route = Routes.sumScreen),
            HomeOption(name = R.string.homeOption_sub, image = R.drawable.operacao_subtrair, route = Routes.subScreen),
            HomeOption(name = R.string.homeOption_multi, image = R.drawable.operacao_multiplicar, route = Routes.multiScreen),
            HomeOption(name = R.string.homeOption_div, image = R.drawable.operacao_dividir, route = Routes.divScreen)
        )
    }
}