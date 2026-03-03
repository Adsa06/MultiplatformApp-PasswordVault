package dev.adsa.multiplatformapp_passwordvault.ui.navigation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.adsa.multiplatformapp_passwordvault.domain.services.PasswordVaultService
import dev.adsa.multiplatformapp_passwordvault.domain.viewmodels.PasswordListViewModel
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.rememberWindowType
import dev.adsa.multiplatformapp_passwordvault.ui.screens.DetailsScreen
import dev.adsa.multiplatformapp_passwordvault.ui.screens.MainScreen
import dev.adsa.multiplatformapp_passwordvault.ui.screens.SettingsScreen
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language

@Composable
fun AppNavigation(
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit
) {
    val service = remember { PasswordVaultService() }
    val passwordListViewModel: PasswordListViewModel = remember { PasswordListViewModel() }

    LaunchedEffect(Unit) {
        passwordListViewModel.inicializate(service)
    }

    val customColors = LocalCustomColors.current

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val windowType = rememberWindowType(maxWidth) // maxWidth viene del scope
        var currentScreen by remember { mutableStateOf(AppScreens.MainScreen.route) }

        Row (
            modifier = Modifier.fillMaxSize()
        ) {
            if(windowType == WindowType.Expanded) {
                NavigationColumn(
                    currentScreen = currentScreen,
                    navigate = { route -> currentScreen = route},
                    onLanguageChange = onLanguageChange,
                    onThemeChange = onThemeChange
                )
                VerticalDivider(color = customColors.divider, thickness = 1.dp)
            }

            when (currentScreen) {
                AppScreens.MainScreen.route -> {
                    MainScreen(
                        navigate = { route -> currentScreen = route },
                        passwordListViewModel = passwordListViewModel,
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
}