package dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage

@Composable
fun SelectLanguaje(onLanguageChange: (Language) -> Unit) {
    val currentLang = LocalLanguage.current
    Column {
        Button(
            onClick = {
                if(currentLang == Language.EN)
                    onLanguageChange(Language.ES)
                else
                    onLanguageChange(Language.EN)
            }
        ) {
            Text("Select languaje")
        }
    }
}

@Composable
fun ToggleTheme(onThemeChange: (Boolean) -> Unit) {
    val isDark = LocalDarkTheme.current
    Column {
        Button(
            onClick = { onThemeChange(!isDark) }
        ) {
            Text("Toggle theme")
        }
    }
}