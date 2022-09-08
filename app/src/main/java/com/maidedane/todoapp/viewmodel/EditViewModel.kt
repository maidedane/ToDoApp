package com.maidedane.todoapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.repository.TodoRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val repoImplement: TodoRepoImplement) :
    ViewModel() {

    private val _state = mutableStateOf(EditState())
    val state: State<EditState> = _state

   fun update(title:String,description:String)=viewModelScope.launch {
       val todo=Todo(title,description)
       repoImplement.updateTodo(todo)
   }

    data class EditState(val todo: List<Todo> = emptyList())
}
