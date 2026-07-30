package com.vishal.kmpnotes.tasks.add_edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vishal.common.components.NotesAppBar
import com.vishal.common.ui.AppColors

@Composable
fun AddEditTaskScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(color = AppColors.black)
            .drawBehind {
                val marginPx = 12.dp.toPx()
                val radiusPx = 100.dp.toPx()

                val centerX = marginPx + radiusPx
                val centerY = marginPx + radiusPx

                val figmaBlurPx = 200.dp.toPx()
                val totalSpreadRadius = radiusPx + figmaBlurPx

                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            AppColors.peach.copy(alpha = .6f),
                            AppColors.peach.copy(alpha = .4f),
                            Color.Transparent
                        ),
                        center = Offset(centerX, centerY),
                        radius = totalSpreadRadius,
                    ),
                    radius = totalSpreadRadius,
                    center = Offset(centerX, centerY),
                )
            },
        containerColor = Color.Transparent,
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            NotesAppBar(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp),
            ) {  }
        }

    }
}