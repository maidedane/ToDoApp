package com.maidedane.todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoList")
class Todo(
    val title:String,
    val description:String,

    @PrimaryKey(autoGenerate = true)
    val id:Int=0
) {
}