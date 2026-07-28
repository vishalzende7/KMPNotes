package com.vishal.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.vishal.common.ui.AppColors

@Composable
fun RoundButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(shape = RoundedCornerShape(size = 60.dp))
            .clickable { onClick() }
            .background(color = AppColors.white),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}