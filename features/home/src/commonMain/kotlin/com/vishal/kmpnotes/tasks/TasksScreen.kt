package com.vishal.kmpnotes.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.vishal.common.components.AppChip
import com.vishal.common.ui.AppColors
import com.vishal.domain.task.repository.TasksRepository
import com.vishal.kmpnotes.Platform
import com.vishal.kmpnotes.getPlatform
import com.vishal.kmpnotes.tasks.components.MainAppBar
import com.vishal.kmpnotes.tasks.components.TaskListItem
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.koinInject

@Composable
fun TasksScreen(
    modifier: Modifier = Modifier
) {
    val repo: TasksRepository = koinInject()
    val chips = listOf("All", "In Progress", "On Hold")
    LaunchedEffect(Unit) {
        repo.getAllTasks().collectLatest {  }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    0.0f to AppColors.pastelViolet.copy(alpha = .5f),
                    0.2f to AppColors.skyBlue.copy(alpha = .7f),
                    0.9f to AppColors.golderOrange.copy(alpha = .5f),
                )
            )
            .systemBarsPadding(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
        ) {

            MainAppBar(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 36.dp),
                query = "",
                onQuery = {},
                onCleared = {},
                onAddClick = {}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Manage Your Daily Tasks",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                    .width(260.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))

            when (getPlatform()) {
                Platform.Desktop -> {
                    FlowRow(
                        modifier = Modifier.padding(start = 30.dp),
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
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .horizontalScroll(state = rememberScrollState())
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
            Spacer(modifier = Modifier.height(25.dp))

            repeat(10) {
                TaskListItem(
                    modifier = Modifier.padding(horizontal = 30.dp)
                )
            }


        }
    }
}