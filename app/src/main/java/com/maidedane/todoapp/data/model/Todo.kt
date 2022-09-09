package com.maidedane.todoapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoList")
class Todo(
    var title: String,
    var description: String,
    var isEdited: Boolean = false,

    @PrimaryKey(autoGenerate = true)
val id: Int = 0
)