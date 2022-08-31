package com.maidedane.todoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.maidedane.todoapp.nav.TodoNavHost
import com.maidedane.todoapp.presentation.ui.theme.ToDoAppTheme
import com.maidedane.todoapp.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
