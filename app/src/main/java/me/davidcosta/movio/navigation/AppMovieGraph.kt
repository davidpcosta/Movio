package me.davidcosta.movio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object AppMovieGraph

@Serializable
object AppMovieHomeScreen

@Serializable
data class AppMovieDetailScreen(
    val movieId: Int
)


fun NavGraphBuilder.movieGraph(navHosController: NavHostController) {
    navigation<AppMovieGraph>(startDestination = AppMovieHomeScreen) {
        composable<AppMovieHomeScreen> {
            AppMovieHomeScreen(navHosController)
        }
        composable<AppMovieDetailScreen> {
            AppMovieDetailScreen(navHosController)
        }
    }
}


@Composable
fun AppMovieHomeScreen(navHostController: NavHostController) {}

@Composable
fun AppMovieDetailScreen(navHostController: NavHostController) {}