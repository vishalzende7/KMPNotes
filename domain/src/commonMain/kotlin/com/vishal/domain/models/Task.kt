package com.vishal.domain.models

data class Task(
    val id: Int,
    val title: String,
    val content: String,
    val onHold: Boolean,
    val taskDate: Long,
    val isCompleted: Boolean
)
