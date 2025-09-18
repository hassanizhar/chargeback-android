package com.example.chargeback.data.model

import androidx.annotation.DrawableRes
import com.example.chargeback.R

enum class AppName(
    val displayName: String,
    @DrawableRes val imageResourceId: Int
) {
    NETFLIX("Netflix", R.drawable.netflix),
    AMAZON_PRIME("Amazon Prime", R.drawable.prime),
    OSN_PLUS("OSN+", R.drawable.osn),
    YOUTUBE("YouTube", R.drawable.youtube),
    OOREDOO("Ooredoo", R.drawable.ooredoo);
}