package dev.adsa.multiplatformapp_passwordvault.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.SelectLanguaje
import dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components.ToggleTheme
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalDarkTheme
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Language
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.app_icon
import multiplatformapppasswordvault.composeapp.generated.resources.dark_theme_icon
import multiplatformapppasswordvault.composeapp.generated.resources.light_theme_icon
import multiplatformapppasswordvault.composeapp.generated.resources.world_icon
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavigationColumn(
    navigate: (String) -> Unit,
    onLanguageChange: (Language) -> Unit,
    onThemeChange: (Boolean) -> Unit,
    currentScreen: String,
) {
    val customColors = LocalCustomColors.current
    val isDark = LocalDarkTheme.current

    Column(
        modifier = Modifier
            .background(color = customColors.topbarBackground)
            .width(200.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Blue, shape = RoundedCornerShape(10.dp))
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.app_icon),
                    tint = Color.White,
                    contentDescription = t(StringKey.AppName),
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = t(StringKey.AppName),
                color = customColors.text,
                style = MaterialTheme.typography.titleLarge
            )
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = customColors.dividir, thickness = 1.dp)
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().weight(1f)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Card {
                Row(
                    modifier = Modifier
                        .width(170.dp)
                        .clickable(onClick = { navigate(AppScreens.MainScreen.route) } )
                        .background(color = if(AppScreens.MainScreen.route == currentScreen) Color.Blue else customColors.topbarBackground),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.app_icon),
                        contentDescription = t(StringKey.PasswordSection),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 6.dp)
                            .offset(y = 4.dp)
                    )
                    Text(
                        text = t(StringKey.PasswordSection),
                        color = if(AppScreens.MainScreen.route == currentScreen) Color.White else customColors.text,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            }

            Card {
                Row(
                    modifier = Modifier
                        .width(170.dp)
                        .clickable(onClick = { navigate(AppScreens.SettingsScreen.route) } )
                        .background(color = if(AppScreens.SettingsScreen.route == currentScreen) Color.Blue else customColors.topbarBackground),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.app_icon),
                        contentDescription = t(StringKey.Configuration),
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 6.dp)
                            .offset(y = 4.dp)
                    )
                    Text(
                        text = t(StringKey.Configuration),
                        color = if(AppScreens.SettingsScreen.route == currentScreen) Color.White else customColors.text,
                        modifier = Modifier.padding(start = 6.dp)
                    )
                }
            }
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = customColors.dividir, thickness = 1.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(if (isDark) Res.drawable.dark_theme_icon else Res.drawable.light_theme_icon),
                contentDescription = t(StringKey.Appearance),
                modifier = Modifier.size(40.dp).padding(horizontal = 8.dp),
                tint = if (isDark) Color.Blue else Color(0xffe6d125)
            )
            Text(
                text = t(StringKey.Appearance),
                style = MaterialTheme.typography.bodyMedium,
                color = customColors.text,
                modifier = Modifier
                    .weight(1f)
            )
            ToggleTheme(
                modifier = Modifier
                    .offset(x = 8.dp)
                    .scale(0.5f),
                onThemeChange = onThemeChange
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Icon(
                painter = painterResource(Res.drawable.world_icon),
                contentDescription = t(StringKey.Language),
                modifier = Modifier.size(40.dp).padding(horizontal = 8.dp),
                tint = Color.Blue
            )
            Text(
                text = t(StringKey.Language),
                style = MaterialTheme.typography.bodyMedium,
                color = customColors.text,
                modifier = Modifier.weight(1f)
            )
            SelectLanguaje(
                modifier = Modifier
                    .offset(x = (8).dp)
                    .scale(0.75f),
                onLanguageChange = onLanguageChange
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationColumnPreview() {
    NavigationColumn(
        navigate = { },
        onLanguageChange = { },
        onThemeChange = { },
        currentScreen = ""
    )
}