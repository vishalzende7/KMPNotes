package com.vishal.kmpnotes.home.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vishal.common.components.AppChip
import com.vishal.kmpnotes.Platform
import com.vishal.kmpnotes.getPlatform

val chips = listOf("All", "In Progress", "On Hold")

@Composable
fun FilterComponent(
    modifier: Modifier = Modifier,
) {
    when (getPlatform()) {
        Platform.Desktop -> {
            FlowRow(
                modifier = modifier.padding(start = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                chips.forEach {
                    AppChip(
                        label = it,
                        onClick = {}
                    )
                }
            }
        }

        Platform.IOS,
        Platform.Android -> {
            Row(
                modifier = modifier
                    .padding(start = 30.dp)
                    .horizontalScroll(state = rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                chips.forEach {
                    AppChip(
                        label = it,
                        onClick = {}
                    )
                }
            }
        }
    }
}