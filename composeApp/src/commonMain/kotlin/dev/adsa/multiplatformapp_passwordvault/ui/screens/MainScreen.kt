package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.components.main_components.MainTopBar
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.AppearanceSettingsCard
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.DataManagementSettingsCard
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SelectLanguaje
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SettingsTopBar
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.ToggleTheme
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.dark_theme_icon
import multiplatformapppasswordvault.composeapp.generated.resources.export_icon
import multiplatformapppasswordvault.composeapp.generated.resources.import_icon
import multiplatformapppasswordvault.composeapp.generated.resources.light_theme_icon
import multiplatformapppasswordvault.composeapp.generated.resources.world_icon

@Composable
fun MainScreen(
    navigate: (String) -> Unit,
    windowType: WindowType
) {
    when (windowType) {
        WindowType.Compact, WindowType.Medium -> CompactAndMediumMainScreen(navigate)
        WindowType.Expanded -> ExpandedMainScreen(navigate)
    }
}

@Composable
fun CompactAndMediumMainScreen(
    navigate: (String) -> Unit
) {
    val customColors = LocalCustomColors.current
    val isDark = LocalDarkTheme.current
    val currentLang = LocalLanguage.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        var query by remember { mutableStateOf("") }
        MainTopBar(
            navigate = navigate,
            query = query,
            onQueryChange = { query = it}
        )

    }
}

@Composable
fun ExpandedMainScreen(
    navigate: (String) -> Unit
) {
    Text("Expanded")
}