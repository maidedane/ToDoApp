package com.maidedane.todoapp.data.room

import androidx.room.*
import com.maidedane.todoapp.data.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun getTodo(): Flow<List<Todo>>

    @Query("SELECT * FROM todo WHERE id=:id")
    suspend fun getTodoById(id:Int): Todo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)
}