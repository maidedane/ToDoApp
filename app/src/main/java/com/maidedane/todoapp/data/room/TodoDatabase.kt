package com.maidedane.todoapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.maidedane.todoapp.data.model.Todo

@Database(

    entities = [Todo::class],
    version = 1
)

abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {

        @Volatile
        private var instance: TodoDatabase? = null

        private val lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also { instance = it }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, TodoDatabase::class.java, "tododatabase"
        ).build()
    }
}
