package com.vishal.data.source

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.vishal.data.entity.TaskEntity
import com.vishal.data.task.local.TaskDao

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
@ConstructedBy(DatabaseConstructor::class)
abstract class NotesDatabase : RoomDatabase() {

    abstract val taskDao: TaskDao
}