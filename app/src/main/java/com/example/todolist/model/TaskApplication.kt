package com.example.todolist.model

import android.app.Application
import androidx.room.Room

class ToDoList : Application() {
    // Initialize the Room database
    val database: TaskDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "Taskdb" // Database name
        ).build()
    }
}
