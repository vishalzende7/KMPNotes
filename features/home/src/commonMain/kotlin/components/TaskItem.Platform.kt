package com.vishal.kmpnotes.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun TaskListPlatform(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
)