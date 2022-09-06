package com.maidedane.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.repository.TodoRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(private val repositoryImplement: TodoRepoImplement) :
    ViewModel() {

    fun insert(title: String, description: String) = viewModelScope.launch {
        val todo = Todo(title = title, description = description)
        repositoryImplement.insertTodo(todo)
    }
}