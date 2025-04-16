package me.davidcosta.movio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavHostV2(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = AppMovieGraph
    ) {
        movieGraph(navHosController)
        tvShowGraph(navHosController)
    }
}