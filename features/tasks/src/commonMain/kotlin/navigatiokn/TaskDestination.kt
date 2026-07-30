package com.vishal.kmpnotes.tasks.navigatiokn

import kotlinx.serialization.Serializable

@Serializable
sealed class TaskDestination {
    @Serializable
    object CreateTask : TaskDestination()
    @Serializable
    data class ViewTask(val taskId: Int) : TaskDestination()
}