package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.adsa.multiplatformapp_passwordvault.domain.models.Password
import dev.adsa.multiplatformapp_passwordvault.domain.viewmodels.PasswordListViewModel
import dev.adsa.multiplatformapp_passwordvault.ui.components.main_components.MainTopBar
import dev.adsa.multiplatformapp_passwordvault.ui.components.main_components.PasswordCard
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage
import androidx.compose.foundation.lazy.grid.items

@Composable
fun MainScreen(
    navigate: (String) -> Unit,
    passwordListViewModel: PasswordListViewModel,
    windowType: WindowType
) {
    LaunchedEffect(Unit) {
        passwordListViewModel.loadPasswordList()
    }

    val passwords by passwordListViewModel.passwords.collectAsState()

    when (windowType) {
        WindowType.Compact, WindowType.Medium ->
            CompactAndMediumMainScreen(
                navigate = navigate,
                passwords = passwords
            )
        WindowType.Expanded ->
            ExpandedMainScreen(
                navigate = navigate,
                passwords = passwords
            )
    }
}

@Composable
fun CompactAndMediumMainScreen(
    navigate: (String) -> Unit,
    passwords: List<Password>
) {
    val customColors = LocalCustomColors.current
    val isDark = LocalDarkTheme.current
    val currentLang = LocalLanguage.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        var query by remember { mutableStateOf("") }
        MainTopBar(
            navigate = navigate,
            query = query,
            onQueryChange = { query = it}
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(
                items = passwords,
                key = { password -> password.id }
            ) { password ->
                PasswordCard(
                    navigate = navigate,
                    password = password
                )
            }
        }
    }
}

@Composable
fun ExpandedMainScreen(
    navigate: (String) -> Unit,
    passwords: List<Password>
) {
    Text("Expanded")
}