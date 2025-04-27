package com.example.todolist


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todolist.model.AppDatabase
import com.example.todolist.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    database: AppDatabase,
    navController: NavHostController
) {
    val taskDao = database.taskDao()
    val tasks by taskDao.getAllTasks().collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        // LazyColumn to display tasks
        LazyColumn(
            modifier = Modifier.weight(1f) // This makes the LazyColumn take all available space
        ) {
            items(tasks) { task ->
                ToDoCard(task, Modifier.padding(8.dp), database)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card at the bottom
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                ElevatedButton(onClick = { navController.navigate("AddScreen") }) {
                    Text("Add Screen") // Go to the add task screen
                }
            }
        }
    }

}


@Composable
fun ToDoCard(task: Task, modifier: Modifier = Modifier, database: AppDatabase) {
    // Card displaying the task details
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp) //make the card look better
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
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    text = task.taskTitle
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp),
                text = task.taskDescription ?: "",
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Add a delete button to remove the task
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        CoroutineScope(Dispatchers.Main).launch {
                            database.taskDao().delete(task)
                        }
                    },
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Text("Delete Task")
                }
            }

        }
    }
}



