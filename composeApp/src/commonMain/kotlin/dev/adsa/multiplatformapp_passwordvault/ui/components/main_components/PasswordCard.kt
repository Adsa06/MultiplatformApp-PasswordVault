package dev.adsa.multiplatformapp_passwordvault.ui.components.main_components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.domain.models.Password
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.arrow_left_icon
import org.jetbrains.compose.resources.painterResource
import sun.security.krb5.EncryptedData

@Composable
fun PasswordCard(
    navigate: (String) -> Unit,
    password: Password
) {
    val customColors = LocalCustomColors.current
    val showPassword by remember { mutableStateOf(false) }

    Card() {
        Column() {
            Row() {
                Text("")
                IconButton(
                    modifier = Modifier.offset(x = (8).dp),
                    onClick = { navigate(AppScreens.SettingsScreen.route) },
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(0.7f),
                        painter = painterResource(Res.drawable.arrow_left_icon),
                        contentDescription = t(StringKey.Configuration),
                        tint = customColors.icon
                    )
                }
            }
            Text(text = (password.password ?: "·".repeat(21)))
            Row() {
                Button(onClick = {}) {

                }
                Button(onClick = {}) {

                }
            }
        }
    }
}

fun decrypt(cryptPassword: String): String {
    return "Ads"
}

@Preview
@Composable
fun PasswordCardPreview() {
    PasswordCard(navigate = { }, password = Password(0,"", "") )
}