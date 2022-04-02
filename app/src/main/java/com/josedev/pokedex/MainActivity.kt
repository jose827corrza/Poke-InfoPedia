package com.josedev.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.josedev.pokedex.pokemondetail.PokemonDetailScreen
import com.josedev.pokedex.pokemonlist.PokemonListScreen
import com.josedev.pokedex.pokemonlist.SplashScreen
import com.josedev.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash_screen"
                    ) {
                        composable("splash_screen") {
                            SplashScreen(navController = navController)
                        }
                        composable("pokedex_list_screen") {
                            PokemonListScreen(navController = navController)
                        }
                        composable(
                            "pokemon_detail_screen/{dominantColor}/{pokemonName}",
                            arguments = listOf(navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                                navArgument("pokemonName") {
                                    type = NavType.StringType
                                })
                        ) {
                            val dominantColor = remember {
                                val color = it.arguments?.getInt("dominantColor")
                                color?.let { Color(it) } ?: Color.White
                            }
                            val pokemonName = remember {
                                it.arguments?.getString("pokemonName")
                            }
                            PokemonDetailScreen(
                                dominantColor = dominantColor,
                                pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}



