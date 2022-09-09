package com.maidedane.todoapp.presentation.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.runBlocking

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel(),
    todoId: Int
) {
    val context = LocalContext.current

    val editState = viewModel.state.value

    val editTitle = remember {
        mutableStateOf(editState.todo?.title)
    }

    val editDescription = remember {
        mutableStateOf(editState.todo?.description)
    }

    LaunchedEffect(key1 = null) {

        viewModel.getTodo(todoId)
        editTitle.value = editState.todo?.title
        editDescription.value = editState.todo?.description
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 15.dp, top = 50.dp, end = 15.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        EditHeadline()

        EditTitle(string = editTitle.value.toString()) { editTitle.value = it }

        EditDescription(string = editDescription.value.toString()) {
            editDescription.value = it
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            EditSaveButton(onClick = {

                if (editTitle.value.isNullOrEmpty()) {

                    Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

                } else if (editDescription.value.isNullOrEmpty()) {

                    Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

                } else {

                    viewModel.update(editTitle.value.toString(), editDescription.value.toString())
                    navController.navigate("home_screen")
                    Toast.makeText(context, "Edited!", Toast.LENGTH_LONG).show()
                }
            })

            EditCancelButton(onClick = {

                viewModel.delete()
                navController.navigate("home_screen")
            })
        }

    }
}
