package com.maidedane.todoapp.repository

import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.data.room.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepoImplement(
    private val dao: TodoDao
) : TodoRepo {
    override fun getTodo(): Flow<List<Todo>> {
        return dao.getTodo()
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)
    }

    override suspend fun insertTodo(todoList: Todo) {
        dao.insertTodo(todoList)
    }

    override suspend fun deleteTodo(todoList: Todo) {
        dao.deleteTodo(todoList)
    }
}