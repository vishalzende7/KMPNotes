package com.vishal.data.di

import com.vishal.data.source.NotesDatabase
import com.vishal.data.source.getRoomDatabase
import com.vishal.data.task.repository.TaskRepositoryImpl
import com.vishal.domain.task.repository.TasksRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single


val dataModules = module {
    includes(platformModule)
    single<NotesDatabase> {
        getRoomDatabase(get())
    }

    single<TaskRepositoryImpl>() bind TasksRepository::class
}

expect val platformModule: Module