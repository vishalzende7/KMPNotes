package com.vishal.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vishal.common.ui.AppColors

@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .widthIn(min = 94.dp)
            .clip(shape = RoundedCornerShape(25.dp))
            .background(color = if (selected) AppColors.black else AppColors.white)
            .clickable { onClick() },
        contentAlignment = Alignment.Center

    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                label,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = if (selected) AppColors.white else AppColors.textOnWhite
                )
            )
            if (selected) {
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier
                        .size(25.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = AppColors.mediumGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "01",
                        style = MaterialTheme.typography.bodySmall
                            .copy(color = AppColors.white)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppChipPreview() {
    AppChip(
        label = "All",
        selected = false,
        onClick = {}
    )
}