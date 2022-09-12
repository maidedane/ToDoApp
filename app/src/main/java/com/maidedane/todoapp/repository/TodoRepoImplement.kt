package com.maidedane.todoapp.repository

import com.maidedane.todoapp.data.model.Todo
import com.maidedane.todoapp.data.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoRepoImplement @Inject constructor(private val dao: TodoDao) : TodoRepository {
    override fun getTodo(): Flow<List<Todo>> {
        Dispatchers.IO.apply { return dao.getTodo() }
    }

    override suspend fun getTodoById(id: Int): Todo {
        Dispatchers.IO.apply { return dao.getTodoById(id) }
    }

    override suspend fun insertTodo(todo: Todo) {
        Dispatchers.IO.apply { dao.insertTodo(todo) }
    }

    override suspend fun updateTodo(todo: Todo) {
        Dispatchers.IO.apply { dao.updateTodo(todo) }
    }

    override suspend fun deleteTodo(todo: Todo) {
        Dispatchers.IO.apply { dao.deleteTodo(todo) }
    }
}