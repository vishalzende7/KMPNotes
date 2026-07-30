package com.vishal.kmpnotes.home

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vishal.common.components.NotesAppBar
import com.vishal.common.ui.AppColors
import com.vishal.kmpnotes.home.components.BottomNavBar
import com.vishal.kmpnotes.home.navigation.BottomNavRoutes
import com.vishal.kmpnotes.home.navigation.HomeDestination
import com.vishal.kmpnotes.home.navigation.HomeRoutes

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToAddTask: () -> Unit
) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to AppColors.pastelViolet.copy(alpha = .5f),
                    0.2f to AppColors.skyBlue.copy(alpha = .7f),
                    0.9f to AppColors.golderOrange.copy(alpha = .5f),
                )
            ),
        containerColor = Color.Transparent,
        bottomBar = {
            var activeDestination by rememberSaveable { mutableStateOf(BottomNavRoutes.Tasks) }
            BottomNavBar(
                modifier = Modifier.padding(bottom = 17.dp, start = 40.dp, end = 40.dp),
                active = activeDestination
            ) {
                navController.navigate(it.destination) {
                    popUpTo(navController.graph.id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                activeDestination = it
            }
        }

    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding(),
            ),
            navController = navController,
            startDestination = HomeRoutes.TaskList
        ) {
            composable<HomeRoutes.TaskList>(
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) { backstackEntry ->
                TasksScreen(
                    onAddTaskClicked = navigateToAddTask,
                    onTaskClicked = {}
                )
            }
            composable<HomeRoutes.Notes>(
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) { backstackEntry ->
                Text("Notes", modifier = Modifier.clickable {
                    navController.popBackStack()
                })
            }
            composable<HomeRoutes.TodoList>(
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideIntoContainer(
                        animationSpec = tween(300, easing = EaseIn),
                        towards = AnimatedContentTransitionScope.SlideDirection.End
                    )
                },
                exitTransition = {
                    fadeOut(
                        animationSpec = tween(
                            300, easing = LinearEasing
                        )
                    ) + slideOutOfContainer(
                        animationSpec = tween(300, easing = EaseOut),
                        towards = AnimatedContentTransitionScope.SlideDirection.Start
                    )
                }
            ) { backstackEntry ->
                Text("Todo List")
            }
        }
    }
}