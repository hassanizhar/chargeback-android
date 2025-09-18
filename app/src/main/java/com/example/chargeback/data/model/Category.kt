package com.example.chargeback.data.model

import androidx.annotation.DrawableRes
import com.example.chargeback.R

enum class Category(val displayName: String, @DrawableRes val imageResourceId: Int) {
    SUBSCRIPTION("Subscription", R.drawable.utitlity),
    UTILITY("Utility", R.drawable.subscription),
    CARD_PAYMENT("Card Payment", R.drawable.card),
    LOAN("Loan", R.drawable.loan),
    RENT("Rent", R.drawable.rent);

    companion object {
        val all = entries // or values() if on Kotlin < 1.9
    }
}