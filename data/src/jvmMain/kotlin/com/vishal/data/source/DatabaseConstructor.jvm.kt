//package com.vishal.data.source
//
//import androidx.room.Room
//import androidx.room.RoomDatabaseConstructor
//import androidx.sqlite.driver.bundled.BundledSQLiteDriver
//import kotlinx.coroutines.Dispatchers
//import java.io.File
//
//actual object DatabaseConstructor : RoomDatabaseConstructor<NotesDatabase> {
//    actual override fun initialize(): NotesDatabase {
//        val dbFile = File(System.getProperty("java.io.tmpdir"), "my_room_db.db")
//        return Room.databaseBuilder<NotesDatabase>(
//            name = dbFile.absolutePath
//        ).setDriver(BundledSQLiteDriver())
//            .setQueryCoroutineContext(Dispatchers.IO)
//            .build()
//    }
//}