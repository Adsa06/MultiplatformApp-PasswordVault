package dev.adsa.multiplatformapp_passwordvault.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalDarkTheme = staticCompositionLocalOf<Boolean> { false }
val LocalCustomColors = staticCompositionLocalOf<CustomColors> { CustomColors() }

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = darkBackground,
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = lightBackground,


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

val DarkCustomColors = CustomColors(
    topbarBackground = darkTopbarBackground,
    border = darkBorder,
    text = darkText,
    iconBackground = darkIconBackground,
    cardBackground = darkCardBackground,
    icon = darkIcon
)

val LightCustomColors = CustomColors(
    topbarBackground = lightTopbarBackground,
    border = lightBorder,
    text = lightText,
    iconBackground = lightIconBackground,
    cardBackground = lightCardBackground,
    icon = lightIcon
)

@Composable
fun MultiplatforAppBookShelfTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}