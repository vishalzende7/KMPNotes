package com.vishal.data.source

import android.app.Application
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

actual class DatabaseFactory(
    private val app: Application
) {
    actual fun builder(): NotesDatabase {
        val dbFile = app.getDatabasePath("my_room.db")
        return Room.databaseBuilder<NotesDatabase>(
            context = app,
            name = dbFile.absolutePath
        ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}