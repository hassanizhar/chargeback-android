package com.example.chargeback.ui.theme.components.pickers.frequencyPicker

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chargeback.R
import com.example.chargeback.data.model.Frequency
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.components.common.CustomDivider

@Composable
fun FrequencyPickerItem(
    frequency: Frequency,
    selectedFrequency: Frequency,
    onFrequencySelected: (Frequency) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onFrequencySelected(frequency) }
                .padding(horizontal = 16.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = frequency.displayName,
                color = TextDark,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Checkmark
            if (frequency == selectedFrequency) {
                Icon(
                    painter = painterResource(id = R.drawable.check_circle),
                    contentDescription = "Selected",
                    tint = Color.Unspecified
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomDivider()
        }

    }
}