package com.vishal.kmpnotes.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vishal.kmpnotes.resources.Res
import com.vishal.kmpnotes.resources.inter_variable
import org.jetbrains.compose.resources.Font

@Composable
fun interFontFamily(): FontFamily = FontFamily(
    Font(Res.font.inter_variable, weight = FontWeight.Normal),
    Font(Res.font.inter_variable, weight = FontWeight.SemiBold),
    Font(Res.font.inter_variable, weight = FontWeight.Medium),
)

@Composable
fun noteTypography(): Typography = Typography(
    displaySmall = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 55.sp,
        fontFamily = interFontFamily()
    ),
    titleLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp,
        fontFamily = interFontFamily()
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp,
        fontFamily = interFontFamily()
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp,
        fontFamily = interFontFamily()
    ),
    bodyMediumEmphasized = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp,
        fontFamily = interFontFamily()
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp,
        fontFamily = interFontFamily()
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        fontFamily = interFontFamily()
    ),
)