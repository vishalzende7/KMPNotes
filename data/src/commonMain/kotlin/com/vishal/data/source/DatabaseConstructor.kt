package com.vishal.data.source

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Suppress("KotlinNoActualForExpect")
expect object DatabaseConstructor: RoomDatabaseConstructor<NotesDatabase> {
    override fun initialize(): NotesDatabase
}