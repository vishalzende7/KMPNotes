package com.vishal.kmpnotes.tasks.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.vishal.common.components.AppSearchButton
import com.vishal.common.components.NotesAppBar
import com.vishal.common.components.RoundButton
import com.vishal.common.ui.AppColors
import com.vishal.kmpnotes.resources.Res
import com.vishal.kmpnotes.resources.ic_add
import org.jetbrains.compose.resources.vectorResource

@Composable
fun MainAppBar(
    modifier: Modifier = Modifier,
    query: String,
    onQuery: (query: String) -> Unit,
    onCleared: () -> Unit,
    onAddClick: () -> Unit
) {
    var isSearchExpanded by rememberSaveable { mutableStateOf(false) }
    val rotationDegree by animateFloatAsState(if (isSearchExpanded) 45f else 0f)
    NotesAppBar(modifier = modifier) {
        AppSearchButton(
            modifier = Modifier.weight(1f),
            isExpanded = isSearchExpanded,
            onSearchClicked = {
                isSearchExpanded = !isSearchExpanded
            },
            onQuery = onQuery,
            value = query
        )
        Spacer(modifier = Modifier.width(13.dp))
        RoundButton(
            modifier = Modifier
                .rotate(rotationDegree),
            onClick = {
                if (isSearchExpanded) {
                    onCleared()
                } else {
                    onAddClick()
                }
            }
        ) {
            Icon(imageVector = vectorResource(Res.drawable.ic_add), contentDescription = "")
        }
    }
}