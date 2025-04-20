package me.davidcosta.movio

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import me.davidcosta.movio.home.HomeScreen
import me.davidcosta.movio.movie.MovieScreen
import me.davidcosta.movio.person.PersonDetailsScreen
import me.davidcosta.movio.tvshow.TvShowScreen

@Composable
fun MovioNavHost(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = HomeScreenRoute
    ) {
        composable<HomeScreenRoute> {
            HomeScreen(navHosController)
        }
        composable<MovieDetailsScreenRoute> {
            MovieScreen(navHosController)
        }
        composable<TvShowScreenRoute> {
            TvShowScreen(navHosController)
        }
        composable<PersonDetailsScreenRoute> {
            PersonDetailsScreen(navHosController)
        }
    }
}

@Serializable
object HomeScreenRoute

@Serializable
data class MovieDetailsScreenRoute(
    val movieId: Int
)

@Serializable
data class TvShowScreenRoute(
    val tvShowId: Int
)

@Serializable
data class PersonDetailsScreenRoute(
    val personId: Int
)