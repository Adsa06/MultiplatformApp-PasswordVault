package dev.adsa.multiplatformapp_passwordvault.ui.navigation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.rememberWindowType
import dev.adsa.multiplatformapp_passwordvault.ui.screens.DetailsScreen
import dev.adsa.multiplatformapp_passwordvault.ui.screens.MainScreen
import dev.adsa.multiplatformapp_passwordvault.ui.screens.SettingsScreen
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language

@Composable
fun AppNavigation(
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val windowType = rememberWindowType(maxWidth) // maxWidth viene del scope
        var currentScreen by remember { mutableStateOf(AppScreens.SettingsScreen.route) }

        when (currentScreen) {
            AppScreens.MainScreen.route -> {
                MainScreen(
                    navigate = { route -> currentScreen = route },
                    windowType = windowType
                )
            }
            AppScreens.DetailsScreen.route -> {
                DetailsScreen(
                    navigate = { route -> currentScreen = route}
                )
            }
            AppScreens.SettingsScreen.route -> {
                SettingsScreen(
                    navigate = { route -> currentScreen = route},
                    onLanguageChange = onLanguageChange,
                    onThemeChange = onThemeChange,
                    windowType = windowType
                )
            }
        }
    }
}