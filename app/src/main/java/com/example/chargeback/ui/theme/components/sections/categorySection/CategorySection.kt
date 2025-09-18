package com.example.chargeback.ui.theme.components.sections.categorySection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chargeback.R
import com.example.chargeback.data.model.Category
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.components.common.CustomRow

@Composable
fun CategorySection(
    category: Category,
    onClick: () -> Unit
) {
    CustomRow(
        label = "Category",
        onClick = onClick,
        showDivider = false,
        valueContent = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    painter = painterResource(id = category.imageResourceId),
                    contentDescription = "Dropdown",
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = category.displayName,
                    color = TextDark,
                    style = MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = R.drawable.unfold_more),
                    contentDescription = "Dropdown",
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    )
}