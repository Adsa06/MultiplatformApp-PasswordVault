package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens
import dev.adsa.multiplatformapp_passwordvault.ui.resolution.WindowType

@Composable
fun MainScreen(
    navigate: (String) -> Unit,
    windowType: WindowType
) {
    when (windowType) {
        WindowType.Compact -> CompactMainScreen(navigate)
        WindowType.Medium -> MediumMainScreen(navigate)
        WindowType.Expanded -> ExpandedMainScreen(navigate)
    }
}

@Composable
fun CompactMainScreen(
    navigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text("Pantalla principal")
        Button(
            onClick = { navigate(AppScreens.SecondScreen.route) }
        ) {
            Text("Ir a la pantalla secundaria")
        }
        Button(
            onClick = { navigate(AppScreens.SettingsScreen.route) }
        ) {
            Text("Ir a la pantalla de configuracion")
        }
    }
}

@Composable
fun MediumMainScreen(
    navigate: (String) -> Unit
) {
    Text("Medium")
}

@Composable
fun ExpandedMainScreen(
    navigate: (String) -> Unit
) {
    Text("Expanded")
}