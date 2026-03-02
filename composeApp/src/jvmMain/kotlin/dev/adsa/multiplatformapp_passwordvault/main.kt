package dev.adsa.multiplatformapp_passwordvault

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.app_image
import org.jetbrains.compose.resources.painterResource

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = t(StringKey.AppName),
        icon = painterResource(Res.drawable.app_image)
    ) {
        App()
    }
}
