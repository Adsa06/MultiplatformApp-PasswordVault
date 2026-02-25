package dev.adsa.multiplatformapp_passwordvault.ui.navigation

sealed class AppScreens(val route: String) {
    object MainScreen : AppScreens("main_screen")
    object DetailsScreen : AppScreens("details_screen")
    object SettingsScreen : AppScreens("settings_screen")
}