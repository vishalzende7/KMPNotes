package com.vishal.kmpnotes.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.vishal.kmpnotes.home.navigation.HomeRoutes
import com.vishal.kmpnotes.home.navigation.home
import com.vishal.kmpnotes.tasks.navigatiokn.TaskDestination
import com.vishal.kmpnotes.tasks.navigatiokn.taskFeature

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoutes.Root
    ) {
        home(navController) {
            navController.navigate(TaskDestination.CreateTask) {
                launchSingleTop = true
            }
        }
        taskFeature()
    }
}