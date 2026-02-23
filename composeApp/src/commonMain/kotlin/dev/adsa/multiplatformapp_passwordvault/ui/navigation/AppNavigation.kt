package dev.adsa.multiplatformapp_passwordvault.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import dev.adsa.multiplatformapp_passwordvault.ui.screens.MainScreen
import dev.adsa.multiplatformapp_passwordvault.ui.screens.SecondScreen

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf(AppScreens.MainScreen.route) }

    when (currentScreen) {
        AppScreens.MainScreen.route -> {
            MainScreen(
                navigate = { route -> currentScreen = route }
            )
        }
        AppScreens.SecondScreen.route -> {
            SecondScreen(
                navigate = { route -> currentScreen = route}
            )
        }
    }
}