package com.maidedane.todoapp.presentation.ui.view.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
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

@Composable
fun HomeCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .height(75.dp)
                        .padding(25.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Do Your First Task", style = MaterialTheme.typography.h6)
                }
                IconButton(
                    onClick = {},
                    modifier = Modifier.size(60.dp),

                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "",
                        tint = Color.Black
                    )
                }
            }
        }
    }
}
