package com.example.chargeback.ui.theme.components.sections.dateSection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chargeback.ui.theme.components.common.CustomRow
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DateSection(
    startDate: LocalDate,
    onDateClick: (() -> Unit)? = null,
) {
    CustomRow(
        label = "Start Date",
        onClick = onDateClick,
        showDivider = true,
        valueContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
                Text(
                    text = startDate.format(formatter),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFEFEFEF), // light grey background like iOS pill
                            shape = RoundedCornerShape(50)
                        )
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .clickable {
                            onDateClick?.invoke()
                        }
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    )
}
