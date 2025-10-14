package com.app.movil_examen.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.movil_examen.presentation.screens.Detail.DetailScreen
import com.app.movil_examen.presentation.screens.Home.HomeScreen

sealed class Screen(
    val route: String,
) {
    object Home : Screen("home")

    object Detail : Screen("name/{countryName}") {
        fun createRoute(countryName: String) = "name/$countryName"
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onCountryClick = { movieId ->
                    navController.navigate(Screen.Detail.createRoute(movieId))
                },
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("countryName") { type = NavType.StringType }),
        ) { backStackEntry ->
            val countryName = backStackEntry.arguments?.getString("countryName") ?: "Mexico"
            DetailScreen(
                countryName = countryName,
                onBackClick = { navController.popBackStack() },
            )
        }

    }
}
