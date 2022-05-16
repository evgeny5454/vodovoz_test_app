package com.evgeny_minaenkov.vodovozapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.evgeny_minaenkov.vodovozapp.data.model.Data
import com.evgeny_minaenkov.vodovozapp.view_model.MainViewModel

@Composable
fun Navigation(
    navHostController: NavHostController,
    section: String,
    tovary: Map<String, List<Data>>,
    mainViewModel: MainViewModel
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(Screen.MainScreen.route) {
            MainScreen(
                tovary = tovary,
                section = section,
                mainViewModel = mainViewModel
            )
        }
        composable(
            route = Screen.MainScreen.route + "/{$section}",
            arguments = listOf(
                navArgument(section) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { entry ->
            MainScreen(
                tovary = tovary,
                section = entry.arguments?.getString(section),
                mainViewModel = mainViewModel
            )
        }
    }
}