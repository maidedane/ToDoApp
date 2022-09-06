package com.maidedane.todoapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maidedane.todoapp.presentation.ui.view.HomeScreen
import com.maidedane.todoapp.presentation.ui.view.ToDoScreen

@Composable
fun TodoNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") { HomeScreen(navController = navController) }
        composable("to_do_screen") { ToDoScreen(navController = navController) }
    }
}