package com.example.todolist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.model.AppDatabase

@Composable
fun TaskApp(dp: AppDatabase) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            ListScreen(modifier = Modifier, database = dp, navController = navController)
        }
        composable("AddScreen") {
            AddScreen(modifier = Modifier, database = dp, navController = navController)
        }
    }

}
