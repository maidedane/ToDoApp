package com.maidedane.todoapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maidedane.todoapp.ui.view.HomeScreen
import com.maidedane.todoapp.ui.view.ToDoScreen



@Composable
fun TodoNavHost() {
    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = "home_screen/{firstTitle}"
    ) {
        composable("home_screen/{firstTitle}", content = { HomeScreen(
            navController = navController,
            titleFromUser = it.arguments?.getString("firstTitle")
        )
        })

        composable("to_do_screen", content = { ToDoScreen(navController = navController) })

    }

}