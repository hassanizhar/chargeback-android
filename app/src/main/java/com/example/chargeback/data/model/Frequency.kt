package com.example.chargeback.data.model

enum class Frequency(val displayName: String) {
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    ANNUALLY("Annually");

    companion object {
        val all = entries // or values() if on Kotlin < 1.9
    }
}