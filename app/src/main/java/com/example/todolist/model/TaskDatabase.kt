package com.example.todolist.model

import androidx.room.Database

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase (){
    abstract fun TaskDao(): TaskDao
}