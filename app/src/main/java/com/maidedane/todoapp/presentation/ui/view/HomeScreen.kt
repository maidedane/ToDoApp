package com.maidedane.todoapp.presentation.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maidedane.todoapp.presentation.ui.view.component.AddButton
import com.maidedane.todoapp.presentation.ui.view.component.AppBar
import com.maidedane.todoapp.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val todoState = viewModel.state.value

    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        topBar = { AppBar() },
        floatingActionButton = { AddButton(navController = navController) },
        ) { paddingValues ->
        paddingValues

        /*LazyColumn {
            itemsIndexed(items = todo) { index, item -> HomeCard() }
        }*/
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            todoState.todo.forEach { todo ->
                Text(
                    text = "Title: ${todo.title} ",
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    textAlign = TextAlign.Center, color = Color.Gray
                )
            }
        }
    }
}








