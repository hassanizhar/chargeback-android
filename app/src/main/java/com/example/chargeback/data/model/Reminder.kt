package com.example.chargeback.data.model

enum class Reminder(val displayName: String) {
    SAME_DAY("Same day"),
    ONE_DAY_BEFORE("1 day before"),
    TWO_DAYS_BEFORE("2 days before");

    companion object {
        val all = entries // or values() if on Kotlin < 1.9
    }
}