package com.maidedane.todoapp.presentation.ui.view.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun EditHeadline() {

    Text(
        text = "Edit Your Task",
        fontSize = MaterialTheme.typography.h5.fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun EditTitle(string: String, function: (String) -> Unit) {

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
fun EditDescription(string: String, function: (String) -> Unit) {

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
fun EditSaveButton(onClick: () -> Unit) {

    OutlinedButton(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        onClick = onClick,
        modifier = Modifier
            .height(50.dp)
            .width(150.dp)
    ) {

        Text(
            text = "Save",
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun EditCancelButton(onClick: () -> Unit) {

    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        modifier = Modifier
            .height(50.dp)
            .width(150.dp)
    ) {
        Text(
            text = "Delete",
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}