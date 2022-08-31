package com.maidedane.todoapp.di

import android.content.Context
import androidx.room.Room
import com.maidedane.todoapp.data.room.TodoDao
import com.maidedane.todoapp.data.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDao(todoDb: TodoDatabase): TodoDao {
        return todoDb.todoDao()
    }

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext appContext: Context): TodoDatabase {
        return Room.databaseBuilder(appContext, TodoDatabase::class.java, "todoList").build()

    }


}