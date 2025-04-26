package com.example.todolist


import android.app.Application
import androidx.room.Room
import com.example.todolist.model.AppDatabase

class TodoDBApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "ToDODB"
        ).build()
    }
}
