package dev.adsa.multiplatformapp_passwordvault.ui.translations

sealed interface StringKey {
    data object AppearanceModeIcon: StringKey
    data object GoBack: StringKey
    data object Configuration: StringKey
    data object Test: StringKey
    data class HolaNombre(val nombre: String): StringKey
}