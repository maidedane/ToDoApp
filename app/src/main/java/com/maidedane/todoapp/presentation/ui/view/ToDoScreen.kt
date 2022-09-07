package com.maidedane.todoapp.presentation.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.maidedane.todoapp.presentation.ui.view.component.*
import com.maidedane.todoapp.viewmodel.TodoViewModel

@Composable
fun ToDoScreen(
    navController: NavController,
    viewModel: TodoViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val myTitle = remember {
        mutableStateOf("")
    }

    val myDescription = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 15.dp, top = 50.dp, end = 15.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Headline()

        TitleTextField(string = myTitle.value) { myTitle.value = it }

        DescriptionTextField(string = myDescription.value) { myDescription.value = it }

        SaveButton(onClick = {

            if (myTitle.value.isEmpty()) {

                Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

            } else if (myDescription.value.isEmpty()) {

                Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

            } else {

                viewModel.insert(title = myTitle.value, description = myDescription.value)
                navController.navigate("home_screen")
                Toast.makeText(context, "Saved!", Toast.LENGTH_LONG).show()
            }
        })
    }
}
