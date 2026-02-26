package dev.adsa.multiplatformapp_passwordvault

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterNone
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.app_icon
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
    val windowState = rememberWindowState()
    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        undecorated = true,
        title = t(StringKey.AppName),
        icon = painterResource(Res.drawable.app_icon)
    ) {
        Column {
            WindowDraggableArea(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                windowState.placement = if (windowState.placement == WindowPlacement.Maximized) {
                                    WindowPlacement.Floating
                                } else {
                                    WindowPlacement.Maximized
                                }
                            }
                        )
                    }
                    .pointerInput(windowState.placement) {
                        if (windowState.placement == WindowPlacement.Maximized) {
                            detectDragGestures { _, _ ->
                                windowState.placement = WindowPlacement.Floating
                            }
                        }
                    }
            ) {
                TopAppBar(
                    title = { Text(t(StringKey.AppName)) },
                    actions = {
                        IconButton(onClick = {
                            windowState.isMinimized = true
                        }) {
                            Icon(Icons.Filled.Remove, contentDescription = "Minimizar")
                        }
                        IconButton(onClick = {
                            if (windowState.placement == WindowPlacement.Maximized) {
                                windowState.placement = WindowPlacement.Floating
                            } else {
                                windowState.placement = WindowPlacement.Maximized
                            }
                        }) {
                            if (windowState.placement == WindowPlacement.Maximized) {
                                Icon(Icons.Filled.FilterNone, contentDescription = "Restaurar")
                            } else {
                                Icon(Icons.Filled.CheckBoxOutlineBlank, contentDescription = "Maximizar")
                            }
                        }
                        IconButton(onClick = {
                            exitApplication()
                        }) {
                            Icon(Icons.Filled.Close, contentDescription = "Cerrar")
                        }
                    }
                )
            }
            App()
        }
    }
}
