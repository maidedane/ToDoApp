package com.maidedane.todoapp.repository

import com.maidedane.todoapp.data.model.Todo
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface TodoRepository {


    fun getTodo(): Flow<List<Todo>>

    suspend fun getTodoById(id: Int): Todo?

    suspend fun insertTodo(todo: Todo)

    suspend fun deleteTodo(todo: Todo)
}