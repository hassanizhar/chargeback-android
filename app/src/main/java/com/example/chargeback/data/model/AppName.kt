package com.example.chargeback.data.model

enum class AppName(val displayName: String, val imageName: String) {
    NETFLIX("Netflix", "netflix"),
    AMAZON_PRIME("Amazon Prime", "prime"),
    OSN_PLUS("OSN+", "osn"),
    YOUTUBE("YouTube", "youtube"),
    OOREDOO("Ooredoo", "ooredoo");

    companion object {
        val all = entries // or values() on older Kotlin versions
    }
}