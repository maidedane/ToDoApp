package com.maidedane.todoapp.presentation.ui.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Headline() {

    Text(
        text = "Add New To Do Task",
        fontSize = MaterialTheme.typography.h5.fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TitleTextField(string: String, function: (String) -> Unit) {

    OutlinedTextField(
        value = string,
        onValueChange = function,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body2,
        singleLine = true,
        label = {
            Text(
                "Title",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = Color.Black
            )
        }
    )
}

@Composable
fun DescriptionTextField(string: String, function: (String) -> Unit) {

    OutlinedTextField(
        value = string,
        onValueChange = function,
        modifier = Modifier.fillMaxWidth(),
        label = {
            Text(
                "Description",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.body1.fontSize,
                color = Color.Black
            )
        },
        textStyle = MaterialTheme.typography.body2,
    )
}

@Composable
fun SaveButton(onClick: () -> Unit) {

    OutlinedButton(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),

        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = "Save",
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

