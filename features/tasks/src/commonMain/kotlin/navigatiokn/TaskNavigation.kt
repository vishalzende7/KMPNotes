package com.vishal.kmpnotes.tasks.navigatiokn

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vishal.kmpnotes.tasks.add_edit.AddEditTaskScreen

fun NavGraphBuilder.taskFeature() {
    composable<TaskDestination.CreateTask> (
        enterTransition = {
            fadeIn(
                animationSpec = tween(200, easing = LinearEasing)
            ) + slideIntoContainer(
                animationSpec = tween(200, easing = EaseIn),
                towards = AnimatedContentTransitionScope.SlideDirection.Start
            )
        },
        exitTransition = {
            fadeOut(
                animationSpec = tween(
                    300, easing = LinearEasing
                )
            ) + slideOutOfContainer(
                animationSpec = tween(300, easing = EaseOut),
                towards = AnimatedContentTransitionScope.SlideDirection.End
            )
        }
    ) {
        AddEditTaskScreen()
    }
}