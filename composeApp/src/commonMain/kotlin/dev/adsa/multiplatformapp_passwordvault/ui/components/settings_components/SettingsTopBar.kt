package dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppScreens
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.arrow_left_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun SettingsTopBar(
    navigate: (String) -> Unit
) {
    val customColors = LocalCustomColors.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(customColors.topbarBackground)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navigate(AppScreens.MainScreen.route) },
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(
                    modifier = Modifier.fillMaxSize(0.7f),
                    painter = painterResource(Res.drawable.arrow_left_icon),
                    contentDescription = t(StringKey.GoBack),
                    tint = customColors.icon
                )
            }
            Text(
                text = t(StringKey.Configuration),
                color = customColors.text
            )
        }
        HorizontalDivider(thickness = 3.dp, color = customColors.border)
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsTopBarPreview() {
    SettingsTopBar( { } )
}