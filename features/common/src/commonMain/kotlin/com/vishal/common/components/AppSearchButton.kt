package com.vishal.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.vishal.common.ui.AppColors
import com.vishal.kmpnotes.resources.Res
import com.vishal.kmpnotes.resources.ic_search
import org.jetbrains.compose.resources.vectorResource

@Composable
fun AppSearchButton(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onSearchClicked: () -> Unit,
    onQuery: (query: String) -> Unit,
    value:String,
) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RoundButton(onClick = onSearchClicked) {
            Icon(imageVector = vectorResource(Res.drawable.ic_search), "")
        }
        AnimatedVisibility(visible = isExpanded) {
            OutlinedTextField(
                modifier = Modifier.padding(start = 4.dp)
                    .fillMaxWidth(),
                value = value,
                onValueChange = onQuery,
                placeholder = { Text("Search Here") },
                shape = RoundedCornerShape(50.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = AppColors.white,
                    focusedContainerColor = AppColors.white,
                    unfocusedBorderColor = AppColors.white,
                    focusedBorderColor = AppColors.white,
                )
            )
        }
    }

}