package com.example.chargeback.ui.theme.components.sections.appSection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.AppName
import com.example.chargeback.ui.theme.components.common.CustomDivider
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.TextLight

@Composable
fun AppSection(
    appName: AppName,
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
                text = "App",
                color = TextLight,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = appName.displayName,
                    color = TextDark,
                    style = MaterialTheme.typography.bodyLarge
                )

                val context = LocalContext.current
                val iconRes = remember {
                    context.resources.getIdentifier("unfold_more", "drawable", context.packageName)
                }
                if (iconRes != 0) {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Dropdown",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }

        CustomDivider()
    }
}