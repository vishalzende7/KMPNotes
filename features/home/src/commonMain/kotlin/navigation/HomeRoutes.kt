package com.vishal.kmpnotes.home.navigation

import com.vishal.kmpnotes.resources.Res
import com.vishal.kmpnotes.resources.ic_contract
import com.vishal.kmpnotes.resources.ic_note_list
import com.vishal.kmpnotes.resources.ic_task_list
import kotlinx.serialization.Serializable
import org.jetbrains.compose.resources.DrawableResource

@Serializable
sealed class HomeRoutes {
    @Serializable
    object Root: HomeRoutes()
    @Serializable
    object TaskList: HomeRoutes()
    @Serializable
    object Notes: HomeRoutes()
    @Serializable
    object TodoList: HomeRoutes()
}

internal interface HomeDestination {
    val icon: DrawableResource
    val title: String
}

internal enum class BottomNavRoutes(val destination: HomeRoutes) : HomeDestination {
    Tasks(HomeRoutes.TaskList) {
        override val icon: DrawableResource
            get() = Res.drawable.ic_task_list
        override val title: String
            get() = "Tasks"
    },
    Notes(HomeRoutes.Notes) {
        override val icon: DrawableResource
            get() = Res.drawable.ic_note_list
        override val title: String
            get() = "Notes"
    },
    Lists(HomeRoutes.TodoList) {
        override val icon: DrawableResource
            get() = Res.drawable.ic_contract
        override val title: String
            get() = "Lists"
    }
}

