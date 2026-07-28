package com.vishal.domain.task.repository

import com.vishal.domain.models.Task
import com.vishal.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    suspend fun createTask(task: Task): Result<Unit>
    fun getAllTasks(): Flow<List<Task>>
}