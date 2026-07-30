package com.vishal.data.source

expect class DatabaseFactory {
    fun builder():NotesDatabase
}