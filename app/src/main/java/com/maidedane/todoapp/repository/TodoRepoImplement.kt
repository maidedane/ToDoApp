package com.maidedane.todoapp.repository

import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.data.room.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoRepoImplement(
    private val dao: TodoDao
) : TodoRepository {
    override fun getTodo(): Flow<List<Todo>> {
        return dao.getTodo()
    }

    override suspend fun getTodoById(id: Int): Todo? {
        return dao.getTodoById(id)
    }

    override suspend fun insertTodo(todo: Todo) {
        dao.insertTodo(todo)
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo)
    }
}