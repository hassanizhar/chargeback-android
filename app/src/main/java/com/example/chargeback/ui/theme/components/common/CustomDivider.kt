package com.example.chargeback.ui.theme.components.common

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chargeback.ui.theme.DividerColor

@Composable
fun CustomDivider() {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        color = DividerColor
    )
}