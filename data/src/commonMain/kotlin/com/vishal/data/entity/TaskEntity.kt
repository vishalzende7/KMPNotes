package com.vishal.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity (
    @PrimaryKey val id:Int = 0,
    val title: String,
    val content: String,
    val onHold: Boolean,
    val taskDate: Long,
    val isCompleted: Boolean
)