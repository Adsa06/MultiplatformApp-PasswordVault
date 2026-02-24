package dev.adsa.multiplatformapp_passwordvault.ui.resolution

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowType(width: Dp): WindowType {
    return when {
        width < 600.dp -> WindowType.Compact
        width < 1200.dp -> WindowType.Medium
        else -> WindowType.Expanded
    }
}