package com.vishal.data.source

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<NotesDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("my_room.db")
    return Room.databaseBuilder<NotesDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}