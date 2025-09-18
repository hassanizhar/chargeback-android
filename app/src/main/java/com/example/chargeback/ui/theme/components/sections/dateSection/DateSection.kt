package com.example.chargeback.ui.theme.components.sections.dateSection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chargeback.ui.theme.TextLight
import com.example.chargeback.ui.theme.components.common.CustomDivider
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DateSection(
    startDate: LocalDate,
    onDateClick: (Any?) -> Unit // you can open a DatePickerDialog here
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Label
            Text(
                text = "Start Date",
                color = TextLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            // Date pill
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

                    }
            )
        }

        CustomDivider()
    }
}
