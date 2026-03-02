package dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage

@Composable
fun SelectLanguaje(
    modifier: Modifier = Modifier,
    onLanguageChange: (Language) -> Unit
) {
    val currentLang = LocalLanguage.current
    var expanded by remember { mutableStateOf(false) }

    Box() {
        Button(
            modifier = modifier,
            onClick = { expanded = true }
        ) {
            Text(currentLang.lang)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Language.entries.forEach {
                DropdownMenuItem(
                    text = { Text(it.lang) },
                    onClick = {
                        onLanguageChange(it)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun ToggleTheme(
    modifier: Modifier = Modifier,
    onThemeChange: (Boolean) -> Unit
) {
    val isDark = LocalDarkTheme.current
    Switch(
        modifier = modifier,
        checked = isDark,
        onCheckedChange = { onThemeChange(it) }
    )
}