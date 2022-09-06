package com.maidedane.todoapp.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.repository.TodoRepoImplement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repositoryImplement: TodoRepoImplement
) : ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        viewModelScope.launch {
            repositoryImplement.getTodo().collect { todoList ->
                _state.value = HomeState(todoList)
            }
        }
    }

    data class HomeState(val todo: List<Todo> = emptyList())
}