package com.vishal.kmpnotes.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.vishal.common.ui.AppColors
import com.vishal.domain.task.repository.TasksRepository
import com.vishal.kmpnotes.home.components.FilterComponent
import com.vishal.kmpnotes.home.components.MainAppBar
import com.vishal.kmpnotes.home.components.TaskListItem
import kotlinx.coroutines.flow.collectLatest
import org.koin.compose.koinInject

@Composable
internal fun TasksScreen(
    modifier: Modifier = Modifier,
    onAddTaskClicked: () -> Unit,
    onTaskClicked: () -> Unit
) {
    val repo: TasksRepository = koinInject()
    LaunchedEffect(Unit) {
        repo.getAllTasks().collectLatest { }
    }
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            MainAppBar(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 12.dp),
                query = "",
                onQuery = {},
                onCleared = {},
                onAddClick = onAddTaskClicked
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

            FilterComponent()
            Spacer(modifier = Modifier.height(25.dp))
        }
        items(10) {
            TaskListItem(
                modifier = Modifier.padding(horizontal = 30.dp)
                    .padding(bottom = 8.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(97.dp))
        }
    }
}