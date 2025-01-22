package com.nive.anime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nive.anime.ui.details.DetailsScreen
import com.nive.anime.ui.details.DetailsViewModel
import com.nive.anime.ui.home.HomeScreen
import com.nive.anime.ui.home.HomeViewModel
import com.nive.anime.ui.theme.AnimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeApp()
        }
    }
}

@Composable
fun AnimeApp() {
    AnimeTheme {
        val navController = rememberNavController()
        AppNavHost(navController = navController)
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    Scaffold { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("home") {
                val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    viewModel = viewModel,
                    onAnimeClick = { animeId ->
                        navController.navigate("detail/$animeId")
                    }
                )
            }

            composable("detail/{animeId}") { backStackEntry ->
                val animeId = backStackEntry.arguments?.getString("animeId")?.toIntOrNull()
                val viewModel = hiltViewModel<DetailsViewModel>()
                animeId?.let {
                    DetailsScreen(
                        animeId = it,
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}


