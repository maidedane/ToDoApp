package com.maidedane.todoapp.presentation.ui.view.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AppBar() {

    TopAppBar(
        contentPadding = PaddingValues(15.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                text = "To Do List",
                fontSize = 35.sp,
                color = Color.White
            )
        }
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

@Composable
fun HomeCard(
    title: String,
    description: String,
    id: Int,
    edit: Boolean,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(15.dp),
            ) {
                Text(text = title, style = MaterialTheme.typography.h6)
                Text(text = description, style = MaterialTheme.typography.body2)
            }
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                IconButton(
                    onClick = { navController.navigate("edit_screen/${id}") },
                    modifier = Modifier
                        .size(20.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.size(55.dp))
                if (edit) {
                    Text(
                        text = "edited",
                        fontSize = MaterialTheme.typography.body2.fontSize,
                        color = Color.Red
                    )
                }
            }
        }
    }
}



