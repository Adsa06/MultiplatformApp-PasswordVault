package dev.adsa.multiplatformapp_passwordvault.ui.translations

object Translations {
    fun get(key: StringKey, lang: Language): String {
        return when (lang) {
            Language.EN -> translateEn(key)
            Language.ES -> translateEs(key)
        }
    }

    private fun translateEn(key: StringKey): String =
        when (key) {
            StringKey.AppearanceModeIcon -> "Appearance Mode Icon"
            is StringKey.HolaNombre -> "Welcome ${key.nombre}"
            StringKey.Test -> "Test"
            StringKey.GoBack -> "Go Back"
            StringKey.Configuration -> "Configuration"
            StringKey.Appearance -> "Appearance"
            StringKey.DataManagement -> "Data Management"
            StringKey.Thema -> "Thema"
            is StringKey.ThemaDescription -> if (key.thema) "Dark Mode" else "Light Mode"
            StringKey.AppName -> "Vault"
            StringKey.Language -> "Language"
            is StringKey.LanguageDescription -> key.lang.lang
        }

    private fun translateEs(key: StringKey): String =
        when (key) {
            StringKey.AppearanceModeIcon -> "Icono de apariencia"
            is StringKey.HolaNombre -> "Bienvenido ${key.nombre}"
            StringKey.Test -> "Test"
            StringKey.GoBack -> "Volver"
            StringKey.Configuration -> "Configuración"
            StringKey.Appearance -> "Apariencia"
            StringKey.DataManagement -> "Gestión de datos"
            StringKey.Thema -> "Tema"
            is StringKey.ThemaDescription -> if (key.thema) "Modo oscuro" else "Modo claro"
            StringKey.AppName -> "Bóveda"
            StringKey.Language -> "Idioma"
            is StringKey.LanguageDescription -> key.lang.lang
        }
}