package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.AppearanceSettingsCard
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SelectLanguaje
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SettingsTopBar
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.ToggleTheme
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.dark_theme_icon
import multiplatformapppasswordvault.composeapp.generated.resources.light_theme_icon

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
    val customColors = LocalCustomColors.current
    val isDark = LocalDarkTheme.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        SettingsTopBar(navigate)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text=t(StringKey.Appearance),
                color = customColors.text
            )
            AppearanceSettingsCard(
                title = t(StringKey.Thema),
                description = t(StringKey.ThemaDescription(isDark)),
                icon = if (isDark) Res.drawable.dark_theme_icon else Res.drawable.light_theme_icon,
                iconColor = if (isDark) Color.Blue else Color.Yellow
            ) {
                SelectLanguaje(onLanguageChange = onLanguageChange)
            }
            AppearanceSettingsCard(
                title = t(StringKey.Thema),
                description = t(StringKey.ThemaDescription(isDark)),
                icon = Res.drawable.dark_theme_icon
            ) {
                ToggleTheme(onThemeChange = onThemeChange)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text=t(StringKey.DataManagement),
                color = customColors.text
            )
            AppearanceSettingsCard(
                title = t(StringKey.Thema),
                description = t(StringKey.ThemaDescription(isDark)),
                icon = Res.drawable.dark_theme_icon
            ) {
                SelectLanguaje(onLanguageChange = onLanguageChange)
            }
            AppearanceSettingsCard(
                title = t(StringKey.Thema),
                description = t(StringKey.ThemaDescription(isDark)),
                icon = Res.drawable.dark_theme_icon
            ) {
                ToggleTheme(onThemeChange = onThemeChange)
            }
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