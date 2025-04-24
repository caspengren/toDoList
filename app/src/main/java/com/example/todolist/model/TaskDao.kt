package com.example.todolist.model

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface TaskDao {
    @Query("SELECT * FROM Task")
    fun getAll(): List<Task>


    @Insert
    fun insertAll(vararg task: Task)

    @Delete
    fun delete(task: Task)
}