package com.example.todolist.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// how we talk to the db room implements everything for us
@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM Task ORDER BY id ASC")
    fun getAllTasks(): Flow<List<Task>>
}