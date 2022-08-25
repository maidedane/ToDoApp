package com.maidedane.todoapp.viewmodel

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.data.room.TodoDatabase
import com.maidedane.todoapp.repository.TodoRepoImplement
import kotlinx.coroutines.launch

class TodoViewModel(context: Context) : ViewModel() {


    val database = TodoDatabase.invoke(context = context)


    fun insert(title: String, description: String) = viewModelScope.launch {

        val todo = Todo(title = title, description = description)

        database.todoDao().insertTodo(todo)

    }

}

data class TodoViewState(
    val title: String = "",
    val description: String = "",
    val todoId: Int = -1,
)

