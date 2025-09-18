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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.Frequency
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
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = frequency.displayName, // or frequency.name if you use enum class
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Checkmark
            if (frequency == selectedFrequency) {
                val context = LocalContext.current
                val checkRes = remember {
                    context.resources.getIdentifier("check_circle", "drawable", context.packageName)
                }
                if (checkRes != 0) {
                    Icon(
                        painter = painterResource(id = checkRes),
                        contentDescription = "Selected",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        CustomDivider()
    }
}