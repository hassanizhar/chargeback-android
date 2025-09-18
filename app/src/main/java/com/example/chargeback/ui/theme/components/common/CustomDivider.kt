package com.example.chargeback.ui.theme.components.common

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CustomDivider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFFDDDDDD) // put your custom color here
    )
}