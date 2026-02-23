package dev.adsa.multiplatformapp_passwordvault.ui.navigation

sealed class AppScreens(val route: String) {
    object MainScreen : AppScreens("main_screen")
    object SecondScreen : AppScreens("second_screen")
}