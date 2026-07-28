package com.vishal.kmpnotes

import android.app.Application
import com.vishal.data.di.dataModules
import org.koin.core.context.startKoin

class NotesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModules)
        }
    }
}