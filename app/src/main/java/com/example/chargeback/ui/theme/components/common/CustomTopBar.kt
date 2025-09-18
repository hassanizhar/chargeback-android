package com.example.chargeback.ui.theme.components.common

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.chargeback.R
import com.example.chargeback.R.drawable
import com.example.chargeback.ui.theme.AppBlue
import com.example.chargeback.ui.theme.TextDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(
    onDismiss: () -> Unit,
    onSave: () -> Unit
) {
    // mimic the screenshot: circular back, bold title, blue Save
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Edit Subscription",
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            IconButton(onClick = onDismiss) {
                Icon(
                    painter = painterResource(id = R.drawable.back_button),
                    contentDescription = "Back",
                    tint = Color.Unspecified // if you want to keep original colors
                )
            }
        },
        actions = {
            TextButton(onClick = onSave) {
                Text("Save", color = AppBlue)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFF5F5F5),
            titleContentColor = TextDark
        )
    )
}
