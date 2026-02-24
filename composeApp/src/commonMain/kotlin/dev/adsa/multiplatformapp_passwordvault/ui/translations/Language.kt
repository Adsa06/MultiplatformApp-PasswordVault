package dev.adsa.multiplatformapp_passwordvault.ui.translations

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf

val LocalLanguage = staticCompositionLocalOf<AppLanguage> { AppLanguage.EN }

@Composable
fun t(key: StringKey): String {
    return Translations.get(key, LocalLanguage.current)
}