package com.vishal.kmpnotes.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vishal.common.ui.AppColors

@Composable
fun TaskListItem(
    modifier: Modifier = Modifier,
) {
    TaskListPlatform(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.linearGradient(
                    listOf(AppColors.pastelViolet, AppColors.peach),
                    start = Offset(20.dp.value, 0f),
                    end = Offset(150.dp.value, Float.POSITIVE_INFINITY)
                )
            ).padding(20.dp)
        ) {
            Column(
            ) {
                Row(
                    verticalAlignment = Alignment.Top,
                ) {
                    Column {
                        Row(

                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TaskChip("25 Sept. 2026")
                            TaskChip("05:20 PM")
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "Meeting with manager at park",
                            modifier = Modifier.width(183.dp),
                            style = MaterialTheme.typography.titleLarge.copy(color = AppColors.white)
                        )
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "This meeting shouldn’t be missed at any cost, It’s really an important meeting with this manager.",
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall.copy(color = AppColors.white)
                )
            }
        }
    }
}

@Composable
fun TaskChip(
    label: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(27.dp)
            .clip(shape = RoundedCornerShape(size = 8.dp))
            .border(
                width = 1.dp,
                color = AppColors.white,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .background(
                brush = Brush.linearGradient(
                    listOf(AppColors.white.copy(alpha = .55F), AppColors.white.copy(alpha = .1f))
                )
            )
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall.copy(color = AppColors.white)
        )
    }
}