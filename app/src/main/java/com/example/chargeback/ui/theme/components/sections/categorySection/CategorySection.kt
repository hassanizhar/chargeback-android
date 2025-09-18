package com.example.chargeback.ui.theme.components.sections.categorySection

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.Category
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.TextLight

@Composable
fun CategorySection(
    category: Category,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Category",
            color = TextLight,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            // Category icon
            val context = LocalContext.current
            val iconRes = remember {
                context.resources.getIdentifier(category.imageName, "drawable", context.packageName)
            }
            if (iconRes != 0) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = category.displayName,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = category.displayName, // rawValue equivalent
                color = TextDark, // Color("TextDark")
                style = MaterialTheme.typography.bodyLarge
            )

            // Dropdown icon
            val dropdownRes = remember {
                context.resources.getIdentifier("unfold_more", "drawable", context.packageName)
            }
            if (dropdownRes != 0) {
                Image(
                    painter = painterResource(id = dropdownRes),
                    contentDescription = "Dropdown",
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}