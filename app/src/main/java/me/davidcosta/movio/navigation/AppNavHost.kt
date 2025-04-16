package me.davidcosta.movio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = AppTvShowHomeScreen
    ) {
        composable<AppTvShowHomeScreen> {
            AppTvShowHomeScreen(navHosController)
        }
        composable<AppTvShowDetailScreen> {
            AppTvShowDetailScreen(navHosController)
        }
        composable<AppSeasonDetailScreen> {
            AppSeasonDetailScreen(navHosController)
        }
        composable<AppEpisodeDetailScreen> {
            AppEpisodeDetailScreen(navHosController)
        }
    }
}