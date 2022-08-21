package com.maidedane.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maidedane.todoapp.nav.TodoNavHost
import com.maidedane.todoapp.ui.theme.ToDoAppTheme
import com.maidedane.todoapp.ui.view.HomeScreen
import com.maidedane.todoapp.ui.view.ToDoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                TodoNavHost()
            }
        }
    }
}
