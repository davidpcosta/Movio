package me.davidcosta.movio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import me.davidcosta.movio.home.HomeScreen
import me.davidcosta.movio.moviedetails.MovieDetailsScreen
import me.davidcosta.movio.person.PersonDetailsScreen

@Composable
fun MovioNavHost(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = HomeScreen
    ) {
        composable<HomeScreen> {
            HomeScreen(navHosController)
        }
        composable<MovieDetailsScreen> {
            MovieDetailsScreen(navHosController)
        }
        composable<PersonDetailsScreen> {
            PersonDetailsScreen(navHosController)
        }
    }
}

@Serializable
object HomeScreen

@Serializable
data class MovieDetailsScreen(
    val movieId: Int
)

@Serializable
data class TvShowDetailsScreen(
    val tvShowId: Int
)

@Serializable
data class PersonDetailsScreen(
    val personId: Int
)