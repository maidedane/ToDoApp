package com.maidedane.todoapp.ui.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.maidedane.todoapp.ui.view.component.DescriptionTextField
import com.maidedane.todoapp.ui.view.component.Headline
import com.maidedane.todoapp.ui.view.component.SaveButton
import com.maidedane.todoapp.ui.view.component.TitleTextField


@Composable
fun ToDoScreen(
    navController: NavController,
) {
    val myString = remember {
        mutableStateOf("")
    }

    val mySecondString = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(start = 15.dp, top = 50.dp, end = 15.dp, bottom = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        Headline()

        TitleTextField(string = myString.value) { myString.value = it }

        DescriptionTextField(string = mySecondString.value) { mySecondString.value = it }

        SaveButton(onClick = {
            //val title =
            if (myString.value.isEmpty()) {

                Toast.makeText(context, "Fields Are Empty!", Toast.LENGTH_LONG).show()

            } else {

                navController.navigate("home_screen/${myString.value}")
                Toast.makeText(context, "Saved!", Toast.LENGTH_LONG).show()
            }
        })
    }
}

