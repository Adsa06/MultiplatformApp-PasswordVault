package dev.adsa.multiplatformapp_passwordvault.ui.translations

object Translations {
    fun get(key: StringKey, lang: AppLanguage): String {
        return when (lang) {
            AppLanguage.EN -> translateEn(key)
            AppLanguage.ES -> translateEs(key)
        }
    }

    private fun translateEn(key: StringKey): String =
        when (key) {
            StringKey.AppearanceModeIcon -> "Appearance Mode Icon"
            is StringKey.HolaNombre -> "Welcome ${key.nombre}"
            StringKey.Test -> "Test"
        }

    private fun translateEs(key: StringKey): String =
        when (key) {
            StringKey.AppearanceModeIcon -> "Icono de apariencia"
            is StringKey.HolaNombre -> "Bienvenido ${key.nombre}"
            StringKey.Test -> "Test"
        }
}