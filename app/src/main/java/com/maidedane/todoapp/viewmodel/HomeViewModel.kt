/*package com.maidedane.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    private val _state = MutableStateFlow(HomeViewState())
    val state: StateFlow<HomeViewState>
        get() = _state

    val doList = todoRepository.getTodo()


    data class HomeViewState(

        val doList: List<Todo> = emptyList(),
    )

    fun delete(todo:Todo)=viewModelScope.launch {
        todoRepository.deleteTodo(todo)
    }



}*/