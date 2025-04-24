package com.example.todolist.model

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
     val taskTitle: String,
     val taskTask: String,
)
