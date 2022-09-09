package com.maidedane.todoapp.presentation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maidedane.todoapp.presentation.ui.view.component.AddButton
import com.maidedane.todoapp.presentation.ui.view.component.AppBar
import com.maidedane.todoapp.presentation.ui.view.component.HomeCard
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
    ) { padding ->
        padding

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(todoState.todo) { todo ->
                HomeCard(
                    title = todo.title,
                    description = todo.description,
                    navController = navController,
                    id = todo.id,
                    edit = todo.isEdited
                )
            }
        }
    }
}









