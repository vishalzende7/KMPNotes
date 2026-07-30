package com.vishal.kmpnotes.home.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.vishal.kmpnotes.home.HomeScreen
import com.vishal.kmpnotes.home.TasksScreen

fun NavGraphBuilder.home(
    navController: NavController,
    navigateToAddTask: () -> Unit
) {
    composable<HomeRoutes.Root> {
        HomeScreen(navigateToAddTask = navigateToAddTask)
    }
}