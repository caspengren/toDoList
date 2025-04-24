package com.example.todolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.model.Task

@Composable
fun ListScreen( modifier: Modifier) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { ListScreen(modifier = Modifier,) }
        composable("AddScreen") { AddScreen(modifier = Modifier) }
    }
    Card(
        modifier = Modifier.fillMaxSize(),

        ) {
        ElevatedButton(onClick = { navController.navigate("AddScreen") }) {
            Text("Add screen")
        }
    }

    /*
    LazyColumn { task ->
        ToDoCard()  something like that i think to populate it at least its 6 am i need to sleep
    }*/
}


@Composable
fun ToDoCard(task: Task, modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(70.dp)
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
                    text = stringResource(id = task.taskTitle)
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp),
                text = stringResource(id = task.taskTask),
            )
        }
    }//end of card

}