package com.maidedane.todoapp.presentation.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maidedane.todoapp.presentation.ui.view.component.*
import com.maidedane.todoapp.viewmodel.EditViewModel

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel(),
    todoId: Int
) {
    val context = LocalContext.current

    val editState = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 15.dp, top = 50.dp, end = 15.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        EditHeadline()

        EditTitle(string = todoId.toString()) { }

        // EditDescription(string =) { }

        EditSaveButton(onClick = {

            if (editState.todo.isEmpty()) {

                Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

            } else if (editState.todo.isEmpty()) {

                Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

            } else {
                navController.navigate("home_screen")
                Toast.makeText(context, "Edited!", Toast.LENGTH_LONG).show()
            }
        })

        EditCancelButton(onClick = {

            navController.navigate("home_screen")
        })
    }
}
