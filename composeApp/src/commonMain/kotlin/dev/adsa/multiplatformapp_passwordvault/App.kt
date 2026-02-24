package dev.adsa.multiplatformapp_passwordvault

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppNavigation
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.theme.MultiplatforAppBookShelfTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.AppLanguage
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage

@Composable
@Preview
fun App() {
    var language by remember { mutableStateOf(AppLanguage.EN) }
    var theme by remember { mutableStateOf(false) }
    MultiplatforAppBookShelfTheme(
        darkTheme = theme
    ) {
        CompositionLocalProvider(
            LocalLanguage provides language,
            LocalDarkTheme provides theme
        ) {
            AppNavigation(
                onLanguageChange = { language = it },
                onThemeChange = { theme = it }
            )
        }
    }
}