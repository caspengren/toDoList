package com.example.todolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todolist.model.AppDatabase
import com.example.todolist.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AddScreen(
    modifier: Modifier = Modifier,
        database: AppDatabase,
    navController: NavHostController
) {
    val taskTitle = remember { mutableStateOf("") }
    val taskDescription = remember { mutableStateOf("") }

    // Coroutine scope to insert data
    val context = LocalContext.current

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        // Screen Title
        Text(text = "Add New Task", modifier = Modifier.padding(bottom = 16.dp))

        // Task Title Input
        TextField(
            value = taskTitle.value,
            onValueChange = { taskTitle.value = it },
            label = { Text("Task Title") },
            modifier = Modifier.padding(bottom = 16.dp),
        )

        // Task Description Input
        TextField(
            value = taskDescription.value,
            onValueChange = { taskDescription.value = it },
            label = { Text("Task Description") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Add Task Button
        Button(
            onClick = {
                if (taskTitle.value.isNotBlank() && taskDescription.value.isNotBlank()) {
                    val newTask = Task(
                        taskTitle = taskTitle.value,
                        taskDescription = taskDescription.value
                    )

                    // Insert the task into the database using a coroutine
                    CoroutineScope(Dispatchers.IO).launch {
                        // Access DAO and insert the task
                        database.taskDao().insert(newTask)

                        // Optionally, clear the fields after insertion
                        taskTitle.value = ""
                        taskDescription.value = ""
                    }
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Add Task")
        }
    }
}
