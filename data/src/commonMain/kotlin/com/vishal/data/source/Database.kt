package com.vishal.data.source

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getRoomDatabase(
    factory: DatabaseFactory
): NotesDatabase {
    return factory.builder()
}