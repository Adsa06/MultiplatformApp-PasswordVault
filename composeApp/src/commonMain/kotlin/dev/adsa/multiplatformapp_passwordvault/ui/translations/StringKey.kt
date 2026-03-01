package dev.adsa.multiplatformapp_passwordvault.ui.translations

import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language as Languages
sealed interface StringKey {
    data object AppearanceModeIcon: StringKey
    data object GoBack: StringKey
    data object Configuration: StringKey
    data object Appearance: StringKey
    data object DataManagement: StringKey
    data object Thema: StringKey
    data class ThemaDescription(val thema: Boolean): StringKey
    data object Language : StringKey
    data class LanguageDescription(val lang: Languages): StringKey
    data object AppName: StringKey
    data object Test: StringKey
    data class HolaNombre(val nombre: String): StringKey
}