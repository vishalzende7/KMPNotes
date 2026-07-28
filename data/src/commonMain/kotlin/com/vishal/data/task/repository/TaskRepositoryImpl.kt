package com.vishal.data.task.repository

import com.vishal.data.entity.TaskEntity
import com.vishal.data.source.NotesDatabase
import com.vishal.domain.models.Result
import com.vishal.domain.models.Task
import com.vishal.domain.task.repository.TasksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.withContext

class TaskRepositoryImpl(
    private val database: NotesDatabase
) : TasksRepository {

    override suspend fun createTask(task: Task): Result<Unit> {
        return withContext(Dispatchers.IO) {
            return@withContext try {
                database.taskDao.insertTask(
                    TaskEntity(
                        title = task.title,
                        content = task.content,
                        onHold = task.onHold,
                        taskDate = task.taskDate,
                        isCompleted = task.isCompleted
                    )
                )
                Result.Success(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                Result.Error(e.message ?: "Error while adding task")
            }
        }
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return database.taskDao.getAllTasks().transform { list ->
            list.map {
                Task(
                    id = it.id,
                    title = it.title,
                    content = it.content,
                    onHold = it.onHold,
                    taskDate = it.taskDate,
                    isCompleted = it.isCompleted
                )
            }.toList()
        }
    }
}