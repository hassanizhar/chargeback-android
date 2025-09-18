package com.example.chargeback.ui.theme.components.sections.amountSection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.TextLight
import com.example.chargeback.ui.theme.components.common.CustomDivider

@Composable
fun AmountSection(
    amount: Double,
    onClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Amount",
                color = TextLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$%.2f".format(amount),
                color = TextDark,
                style = MaterialTheme.typography.bodyLarge
            )
        }

       CustomDivider()
    }
}