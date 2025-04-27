package com.example.todolist.model

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey

//the task class that will be put into the db
@Entity(tableName = "Task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val taskTitle: String,
    val taskDescription: String? = null
)

