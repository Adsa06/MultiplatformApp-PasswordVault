package dev.adsa.multiplatformapp_passwordvault.ui.components.settings_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.adsa.multiplatformapp_passwordvault.ui.theme.LocalCustomColors
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t
import multiplatformapppasswordvault.composeapp.generated.resources.Res
import multiplatformapppasswordvault.composeapp.generated.resources.dark_theme_icon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppearanceSettingsCard(
    title: String,
    description: String,
    icon: DrawableResource,
    iconColor: Color = Color.Unspecified,
    actionContent: @Composable () -> Unit
) {
    val customColors = LocalCustomColors.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background),
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
                    .size(45.dp)
                    .background(Color(0x994a5568), RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = t(StringKey.AppearanceModeIcon),
                    modifier = Modifier.fillMaxSize(0.7f),
                    tint = iconColor
                )
            }
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = customColors.text
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = customColors.text
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            actionContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsCardPreview() {
    AppearanceSettingsCard(
        title = "test",
        description = "test",
        icon = Res.drawable.dark_theme_icon,
        actionContent = {
        Text("Hola")
    } )
}