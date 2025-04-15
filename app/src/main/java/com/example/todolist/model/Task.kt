package com.example.todolist.model

import androidx.annotation.StringRes

data class Task(
    @StringRes val taskTitle: Int,
    @StringRes val taskTask: Int,
)
