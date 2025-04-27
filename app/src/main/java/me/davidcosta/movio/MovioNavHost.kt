package me.davidcosta.movio

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import kotlinx.serialization.Serializable
import me.davidcosta.movio.home.HomeScreen
import me.davidcosta.movio.movie.MovieScreen
import me.davidcosta.movio.person.PersonDetailsScreen
import me.davidcosta.movio.tvshow.TvShowScreen

const val DOMAIN = "myapp://movio.davidcosta.me"

@Composable
fun MovioNavHost(navHosController: NavHostController) {
    NavHost(
        navController = navHosController,
        startDestination = HomeScreenRoute,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(300)
            )
        }
    ) {
        composable<HomeScreenRoute> {
            HomeScreen(navHosController)
        }
        composable<MovieScreenRoute>(
            deepLinks = listOf(
                navDeepLink<MovieScreenRoute>("$DOMAIN/movie")
            )
        ) {
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
data class MovieScreenRoute(
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