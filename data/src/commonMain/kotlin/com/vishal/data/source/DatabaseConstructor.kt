package com.vishal.data.source

import androidx.room.RoomDatabaseConstructor

@Suppress("KotlinNoActualForExpect", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object DatabaseConstructor: RoomDatabaseConstructor<NotesDatabase> {
    override fun initialize(): NotesDatabase
}