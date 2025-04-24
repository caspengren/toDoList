package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.model.Task
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
fun TaskApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home") { ListScreen(Modifier  ) }
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