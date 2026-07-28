package com.vishal.kmpnotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.vishal.data.di.dataModules
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(dataModules)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPNotes",
    ) {
        App()
    }
}