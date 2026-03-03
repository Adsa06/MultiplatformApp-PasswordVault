package dev.adsa.multiplatformapp_passwordvault.domain.services

import dev.adsa.multiplatformapp_passwordvault.domain.models.Password

class PasswordVaultService {

    suspend fun getAllPasswords(): List<Password> {
        val passwords: List<Password> = (1..40)
            .map { Password(
                id = it,
                name = "Password $it",
                password = "password $it"
            ) }
        return passwords
    }
}