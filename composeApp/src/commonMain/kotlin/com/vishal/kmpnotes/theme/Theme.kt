package com.vishal.kmpnotes.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun NoteTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = noteTypography(),
        content = content
    )
}