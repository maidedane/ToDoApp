package com.maidedane.todoapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.repository.TodoRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repoImplement: TodoRepoImplement
) : ViewModel() {

    private val _state = mutableStateOf(EditState())
    val state: State<EditState> = _state

    fun getTodo(id: Int) {
        runBlocking {
            _state.value.todo = repoImplement.getTodoById(id)
        }
    }

    fun update(title: String, description: String) = runBlocking {

        val todo = _state.value.todo?.let { Todo(title, description,isEdited = true, it.id ) }
        if (todo != null) {
            repoImplement.updateTodo(todo)
        }
    }

    fun delete() = viewModelScope.launch {
        _state.value.todo?.let { repoImplement.deleteTodo(it) }
    }

    data class EditState(var todo: Todo? = null)
}
