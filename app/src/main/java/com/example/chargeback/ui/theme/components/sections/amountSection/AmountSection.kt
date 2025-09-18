package com.example.chargeback.ui.theme.components.sections.amountSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.components.common.CustomRow

@Composable
fun AmountSection(
    amount: Double,
    onClick: () -> Unit
) {
    CustomRow(
        label = "Amount",
        onClick = onClick,
        showDivider = true,
        valueContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "$%.2f".format(amount),
                    color = TextDark,
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    )
}