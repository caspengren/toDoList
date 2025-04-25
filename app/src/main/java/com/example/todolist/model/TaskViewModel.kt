package com.example.todolist.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val taskDao = (application as ToDoList).database.taskDao()

    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks().asLiveData()

    fun insert(task: Task) = viewModelScope.launch {
        taskDao.insert(task)
    }


    fun delete(task: Task) = viewModelScope.launch {
        taskDao.delete(task)
    }
}
