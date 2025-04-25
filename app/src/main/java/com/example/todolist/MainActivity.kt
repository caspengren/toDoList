package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.todolist.model.TaskDatabase
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                TaskApp()
            }
        }
    }
}






@Composable
fun TaskApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { ListScreen(Modifier) }
        composable("AddScreen") { AddScreen(Modifier) }
    }
}




/*
val sampleTask =
    Task(taskTitle = R.string.sample_task_title, taskTask = R.string.sample_task_tasktask)

@Preview(showBackground = true)
@Composable
fun cardpre() {
    ToDoCard(sampleTask)
}*/