package com.example.todolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolist.model.TaskViewModel

@Composable
fun AddScreen(modifier: Modifier = Modifier, taskViewModel: TaskViewModel = viewModel()) {

    val taskTitle = remember { mutableStateOf("") }
    val taskDescription = remember { mutableStateOf("") }

    Column(
        modifier = modifier.padding(16.dp),

        ) {
        Text(text = "Add New Task", modifier = Modifier.padding(bottom = 16.dp))

        TextField(
            value = taskTitle.value,
            onValueChange = {taskTitle.value = it},
            label = {Text("Task Title")},
            modifier = Modifier.padding(bottom = 16.dp),
        )//end of title

        TextField(
            value = taskDescription.value,
            onValueChange = { taskDescription.value = it },
            label = { Text("Task Description") },
            modifier = Modifier.padding(bottom = 16.dp)
        )//end of task deescript

    }
}