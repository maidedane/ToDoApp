package com.maidedane.todoapp.data.room

import androidx.room.*
import com.maidedane.todoapp.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todoList")
    fun getTodo(): Flow<List<Todo>>

    @Query("SELECT * FROM todoList WHERE id=:id")
    suspend fun getTodoById(id:Int): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}