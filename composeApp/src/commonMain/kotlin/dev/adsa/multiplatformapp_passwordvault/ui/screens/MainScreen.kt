package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens

@Composable
fun MainScreen(
    navigate: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
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