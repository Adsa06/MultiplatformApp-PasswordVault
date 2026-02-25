package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SelectLanguaje
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SettingsCard
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SettingsTopBar
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.ToggleTheme
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language

@Composable
fun SettingsScreen(
    navigate: (String) -> Unit,
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit,
    windowType: WindowType
) {
    when (windowType) {
        WindowType.Compact, WindowType.Medium-> CompactAndMediumSettingsScreen(
            navigate = navigate,
            onLanguageChange = onLanguageChange,
            onThemeChange = onThemeChange
        )
        WindowType.Expanded -> ExpandedSettingsScreen(
            navigate = navigate,
            onLanguageChange = onLanguageChange,
            onThemeChange = onThemeChange
        )
    }
}

@Composable
fun CompactAndMediumSettingsScreen(
    navigate: (String) -> Unit,
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SettingsTopBar(navigate)

        Text("Pantalla de configuracion")
        SettingsCard {
            SelectLanguaje(onLanguageChange = onLanguageChange)
        }
        SettingsCard {
            ToggleTheme(onThemeChange = onThemeChange)
        }
    }
}

@Composable
fun ExpandedSettingsScreen(
    navigate: (String) -> Unit,
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit
) {
    Text("Expanded")
}



@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(
        navigate = { },
        onLanguageChange = { },
        onThemeChange = { },
        windowType = WindowType.Compact
    )
}