package com.vishal.data.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.vishal.data.source.DatabaseConstructor
import com.vishal.data.source.NotesDatabase
import com.vishal.data.task.repository.TaskRepositoryImpl
import com.vishal.domain.task.repository.TasksRepository
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single


val dataModules = module {
    single<TaskRepositoryImpl>() bind TasksRepository ::class
    single<NotesDatabase> {
        DatabaseConstructor.initialize()
    }
}