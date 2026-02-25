package dev.adsa.multiplatformapp_passwordvault

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppNavigation
import dev.adsa.multiplatformapp_passwordvault.ui.theme.DarkCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LightCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.theme.MultiplatforAppBookShelfTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage

@Composable
@Preview
fun App() {
    var language by remember { mutableStateOf(Language.EN) }
    var theme by remember { mutableStateOf(false) }
    val customColors = if (theme) DarkCustomColors else LightCustomColors

    MultiplatforAppBookShelfTheme(
        darkTheme = theme
    ) {
        CompositionLocalProvider(
            LocalLanguage provides language,
            LocalDarkTheme provides theme,
            LocalCustomColors provides customColors
        ) {
            AppNavigation(
                onLanguageChange = { language = it },
                onThemeChange = { theme = it }
            )
        }
    }
}