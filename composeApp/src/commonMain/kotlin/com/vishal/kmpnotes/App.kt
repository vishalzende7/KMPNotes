package com.vishal.kmpnotes

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vishal.kmpnotes.navigation.RootNavHost
import com.vishal.kmpnotes.theme.NoteTheme

@Composable
fun App() {
    NoteTheme {
        RootNavHost()
    }
}

