package com.vishal.kmpnotes.tasks.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
actual fun TaskListPlatform(
    modifier: Modifier,
    content: @Composable (() -> Unit)
) {
    BoxWithConstraints(modifier = modifier) {
        if (maxWidth < 600.dp) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(245.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {
                content()
            }
        } else {
            Box(
                modifier = Modifier
                    .width(333.dp)
                    .height(245.dp)
                    .clip(shape = RoundedCornerShape(15.dp))
            ) {
                content()
            }
        }
    }
}