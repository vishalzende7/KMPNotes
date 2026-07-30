package com.vishal.data.di

import com.vishal.data.source.DatabaseFactory
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single


actual val platformModule = module {
    single<DatabaseFactory>() bind DatabaseFactory::class
}