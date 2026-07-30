package com.vishal.kmpnotes

import com.vishal.data.di.dataModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(dataModules)
    }
}