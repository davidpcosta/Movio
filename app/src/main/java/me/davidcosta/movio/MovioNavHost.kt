package me.davidcosta.movio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import me.davidcosta.movio.home.HomeScreen
import me.davidcosta.movio.moviedetails.MovieDetailScreen

@Composable
fun MovioNavHost(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
            HomeScreen(navHosController)
        }
        composable<MovieDetailScreen> {
            MovieDetailScreen(navHosController)
        }
    }
}

@Serializable
object HomeScreen

@Serializable
data class MovieDetailScreen(
    val movieId: Int
)

@Serializable
data class TvShowDetailScreen(
    val tvShowId: Int
)