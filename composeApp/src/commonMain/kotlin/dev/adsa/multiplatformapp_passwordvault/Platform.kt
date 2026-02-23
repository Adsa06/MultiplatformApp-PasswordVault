package dev.adsa.multiplatformapp_passwordvault

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform