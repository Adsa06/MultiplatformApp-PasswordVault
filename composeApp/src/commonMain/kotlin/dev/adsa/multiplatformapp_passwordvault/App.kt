package dev.adsa.multiplatformapp_passwordvault

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import dev.adsa.multiplatformapp_passwordvault.ui.navigation.AppNavigation
import dev.adsa.multiplatformapp_passwordvault.ui.translations.AppLanguage
import dev.adsa.multiplatformapp_passwordvault.ui.translations.LocalLanguage
import dev.adsa.multiplatformapp_passwordvault.ui.translations.StringKey
import dev.adsa.multiplatformapp_passwordvault.ui.translations.Translations
import dev.adsa.multiplatformapp_passwordvault.ui.translations.t

@Composable
@Preview
fun App() {
    var language by remember { mutableStateOf(AppLanguage.EN) }

    CompositionLocalProvider(LocalLanguage provides language) {

    }

    MaterialTheme {
        CompositionLocalProvider(LocalLanguage provides language) {
            AppNavigation(
                onLanguageChange = { language = it }
            )
        }

//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
    }
}