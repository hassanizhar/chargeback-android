package com.example.chargeback.ui.theme.components.pickers.categoryPicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import com.example.chargeback.R
import com.example.chargeback.data.model.Category
import com.example.chargeback.ui.theme.components.common.CustomDivider

@Composable
fun CategoryPickerItem(
    category: Category,
    selectedCategory: Category,
    onCategorySelected: (Category) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCategorySelected(category) }
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp) // 30 icon + 8 padding each side
                    .background(
                        color = Color(0xFFF0F0F0), // Replace with your Color("IconBackground")
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = category.imageResourceId),
                    contentDescription = category.displayName,
                    modifier = Modifier.size(30.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = category.displayName,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.weight(1f))

            // Checkmark
            if (category == selectedCategory) {
                Icon(
                    painter = painterResource(id = R.drawable.check_circle),
                    contentDescription = "Selected",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        CustomDivider()
    }
}