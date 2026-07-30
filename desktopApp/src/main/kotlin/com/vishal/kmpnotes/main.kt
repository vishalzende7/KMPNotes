package com.vishal.kmpnotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vishal.kmpnotes.di.initKoin

fun main() = application {
    initKoin {  }
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPNotes",
    ) {
        App()
    }
}