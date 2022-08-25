package com.maidedane.todoapp.ui.view.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.room.Delete
import com.maidedane.todoapp.data.model.Todo

@Composable
fun AppBar() {
    TopAppBar(
        contentPadding = PaddingValues(15.dp),
    ) {
        Text(
            modifier = Modifier.absolutePadding(left = 100.dp),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            text = "To Do List",
            fontSize = 35.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun AddButton(navController: NavController) {

    FloatingActionButton(
        onClick = {
            navController.navigate("to_do_screen")
        },
        backgroundColor = Color.Gray,
        content = {
            Icon(Icons.Filled.Add, contentDescription = "")
        })

}
