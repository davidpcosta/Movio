package me.davidcosta.movio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable

@Serializable
object AppTvShowGraph

@Serializable
object AppTvShowHomeScreen

@Serializable
data class AppTvShowDetailScreen(
    val tvShowId: Int
)

@Serializable
data class AppSeasonDetailScreen(
    val tvShowId: Int,
    val seasonId: Int
)

@Serializable
data class AppEpisodeDetailScreen(
    val tvShowId: Int,
    val episodeId: Int
)

fun NavGraphBuilder.tvShowGraph(navHosController: NavHostController) {
    navigation<AppTvShowGraph>(startDestination = AppTvShowHomeScreen) {
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

@Composable
fun AppTvShowHomeScreen(navHostController: NavHostController) {}

@Composable
fun AppTvShowDetailScreen(navHostController: NavHostController) {}

@Composable
fun AppSeasonDetailScreen(navHostController: NavHostController) {}

@Composable
fun AppEpisodeDetailScreen(navHostController: NavHostController) {}
