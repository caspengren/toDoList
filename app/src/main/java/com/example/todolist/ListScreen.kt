package com.example.todolist


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.model.AppDatabase
import com.example.todolist.model.Task


@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    database: AppDatabase,
    navController: NavHostController
) {

    val navController = rememberNavController()
    val taskDao = database.taskDao()
    val tasks by taskDao.getAllTasks().collectAsState(initial = emptyList())





    Column(modifier = modifier
        .padding(20.dp)
        .fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            ElevatedButton(onClick = { navController.navigate("AddScreen") }) {
                Text("AddScreen")
            }
        }

        LazyColumn {
            items(tasks) { task ->
                ToDoCard(task = task, modifier = Modifier.padding(8.dp))
            }
        }


    }
}


@Composable
fun ToDoCard(task: Task, modifier: Modifier = Modifier) {
    // Card displaying the task details
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp),
                    text = task.taskTitle
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp),
                text = task.taskDescription,
            )

            // Add a delete button to remove the task
            Button(
                onClick = { /*add a delete*/ },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Delete Task")
            }
        }
    }
}

