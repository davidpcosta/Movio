package me.davidcosta.movio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import me.davidcosta.movio.home.HomeScreen
import me.davidcosta.movio.moviedetails.MovieDetailScreen
import me.davidcosta.movio.core.theme.AppTheme

class MainActivity : ComponentActivity() {

    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()

        setContent {

            val navController = rememberNavController()

            AppTheme {
                AppNavHost(navController)
            }
        }
    }
}

@Composable
fun AppNavHost(navHosController: NavHostController) {
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