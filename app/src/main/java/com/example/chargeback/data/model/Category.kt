package com.example.chargeback.data.model

enum class Category(val displayName: String, val imageName: String) {
    SUBSCRIPTION("Subscription", "subscription"),
    UTILITY("Utility", "utility"),
    CARD_PAYMENT("Card Payment", "card"),
    LOAN("Loan", "loan"),
    RENT("Rent", "rent");

    companion object {
        val all = entries // or values() if on Kotlin < 1.9
    }
}