package com.vishal.data.task.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.vishal.data.entity.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Upsert
    suspend fun insertTask(task: TaskEntity)
    @Query("SELECT * from tasks")
    fun getAllTasks(): Flow<List<TaskEntity>>
}