package com.maidedane.todoapp.ui.view


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.maidedane.todoapp.ui.view.component.AddButton
import com.maidedane.todoapp.ui.view.component.AppBar


@Composable
fun HomeScreen(
    navController: NavController,
    titleFromUser: String?,
) {

    /*val viewModel = viewModel(HomeViewModel::class.java)
    val state by viewModel.state.collectAsState()*/

    val titleReceived = titleFromUser ?: ""

    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        topBar = { AppBar() },

        floatingActionButton = { AddButton(navController = navController) },

        ) { paddingValues ->
        paddingValues
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text ="Title: $titleReceived" ,
                fontSize = MaterialTheme.typography.h5.fontSize,
                textAlign = TextAlign.Center, color = Color.Gray,
            )

            }




        }
    }







