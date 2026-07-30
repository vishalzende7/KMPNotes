package com.vishal.kmpnotes.home.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.vishal.common.components.NotesAppBar
import com.vishal.common.ui.AppColors
import com.vishal.kmpnotes.home.navigation.BottomNavRoutes
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun BottomNavBar(
    modifier: Modifier = Modifier,
    active: BottomNavRoutes = BottomNavRoutes.Tasks,
    onDestinationChanged: (selected: BottomNavRoutes) -> Unit
) {
    NotesAppBar(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavRoutes.entries.forEach { entry ->
                NavItem(
                    modifier = Modifier.weight(1f),
                    entry = entry,
                    isActive = entry == active,
                ) {
                    if (entry != active) {
                        onDestinationChanged(entry)
                    }
                }
            }
        }
    }
}

@Composable
private fun NavItem(
    modifier: Modifier = Modifier,
    entry: BottomNavRoutes,
    isActive: Boolean,
    onClick: () -> Unit
) {
    val animatedColor by animateColorAsState(
        targetValue = if (isActive) AppColors.pastelViolet else Color.Transparent
    )
    val animatedIconTint by animateColorAsState(
        targetValue = if (isActive) AppColors.white else AppColors.black
    )
    Surface(
        modifier = modifier
            .fillMaxSize()
            .clickable(onClick = onClick),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(if (isActive) 32.dp else 3.dp))
                    .animateContentSize(
                        alignment = Alignment.Center
                    )
                    .size(if (isActive) 64.dp else 24.dp)
                    .background(color = animatedColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(24.dp),
                    imageVector = vectorResource(entry.icon),
                    contentDescription = entry.title,
                    colorFilter = ColorFilter.tint(color = animatedIconTint)
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
            AnimatedVisibility(!isActive) {
                Text(
                    text = entry.title,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}