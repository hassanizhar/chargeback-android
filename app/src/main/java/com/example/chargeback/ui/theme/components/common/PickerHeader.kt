package com.example.chargeback.ui.theme.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chargeback.R
import com.example.chargeback.ui.theme.AppBlue
import com.example.chargeback.ui.theme.TextDark

@Composable
fun PickerHeader(
    title: String,
    onDoneClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp)
    ) {
        // Title in the center
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.align(Alignment.Center),
            color = TextDark // like Color("TextDark")
        )

        // Done button at end
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = 16.dp)
        ) {
            TextButton(
                onClick = onDoneClick,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = AppBlue // like Color("AppBlue")
                )
            ) {
                Text("Done")
            }
        }
    }
}