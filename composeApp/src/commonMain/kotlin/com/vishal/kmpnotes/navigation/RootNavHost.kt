package com.vishal.kmpnotes.navigation

import com.vishal.kmpnotes.tasks.TasksScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RootNavHost(
     modifier: Modifier = Modifier,
) {
     TasksScreen(modifier)
}