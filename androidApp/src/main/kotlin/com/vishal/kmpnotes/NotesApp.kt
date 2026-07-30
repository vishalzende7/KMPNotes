package com.vishal.kmpnotes

import android.app.Application
import com.vishal.kmpnotes.di.initKoin
import org.koin.android.ext.koin.androidContext

class NotesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@NotesApp)
        }
    }
}