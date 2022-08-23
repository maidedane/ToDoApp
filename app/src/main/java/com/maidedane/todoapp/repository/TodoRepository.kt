package com.maidedane.todoapp.repository

import com.maidedane.todoapp.data.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

    fun getTodo(): Flow<List<Todo>>

    suspend fun getTodoById(id:Int): Todo?

    suspend fun insertTodo(todoList: Todo)

    suspend fun deleteTodo(todoList: Todo)
}