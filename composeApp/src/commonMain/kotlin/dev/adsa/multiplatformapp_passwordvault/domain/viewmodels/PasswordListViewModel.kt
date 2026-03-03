package dev.adsa.multiplatformapp_passwordvault.domain.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.adsa.multiplatformapp_passwordvault.domain.models.Password
import dev.adsa.multiplatformapp_passwordvault.domain.services.PasswordVaultService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PasswordListViewModel: ViewModel() {
    private lateinit var passwordViewModel: PasswordVaultService

    private val _passwords = MutableStateFlow<List<Password>>(emptyList())

    val passwords: StateFlow<List<Password>> = _passwords

    fun inicializate(service: PasswordVaultService) {
        passwordViewModel = service
    }

    fun loadPasswordList() {
        viewModelScope.launch {
            _passwords.value = passwordViewModel.getAllPasswords()
        }
    }
}