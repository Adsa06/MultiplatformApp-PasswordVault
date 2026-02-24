package dev.adsa.multiplatformapp_passwordvault.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens
import dev.adsa.multiplatformapp_passwordvault.ui.translations.AppLanguage
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.AppearanceModeIcon
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.dark_theme_icon
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
@Composable
fun SettingsScreen(
    navigate: (String) -> Unit,
    onLanguageChange: (AppLanguage) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Pantalla de configuracion")
        Button(
            onClick = { navigate(AppScreens.MainScreen.route) }
        ) {
            Text("Ir a la pantalla principal")
        }
        Button(
            onClick = { onLanguageChange(AppLanguage.ES) }
        ) {
            Text("Cambiar el a Español")
        }
        Button(
            onClick = { onLanguageChange(AppLanguage.EN) }
        ) {
            Text("Cambiar el a Ingles")
        }
        SettingsCard()
    }
}

@Composable
fun SettingsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor= Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black,
        ),
        shape = RoundedCornerShape(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.LightGray, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.dark_theme_icon),
                    contentDescription = t(StringKey.AppearanceModeIcon),
                    modifier = Modifier.fillMaxSize(0.7f),
                    tint = Color.Unspecified
                )
            }
            Column(

            ) {
                Text(
                    text = t(StringKey.AppearanceModeIcon)
                )
                Text(
                    text = t(StringKey.AppearanceModeIcon)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen( { }, { })
}