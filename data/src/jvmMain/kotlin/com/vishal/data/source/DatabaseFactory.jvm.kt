package com.vishal.data.source

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import java.io.File

actual class DatabaseFactory {
    actual fun builder(): NotesDatabase {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room.db")
        return Room.databaseBuilder<NotesDatabase>(
            name = dbFile.absolutePath,
        ).setDriver(BundledSQLiteDriver()).build()
    }
}