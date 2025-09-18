package com.example.chargeback.ui.theme.components.pickers.amountPicker


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.chargeback.R
import com.example.chargeback.ui.theme.BorderColor
import com.example.chargeback.ui.theme.TextDark
import com.example.chargeback.ui.theme.components.common.PickerHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountPickerSheet(
    amount: Double,
    onAmountChange: (Double) -> Unit,
    onDismissRequest: () -> Unit
) {
    val borderColor = BorderColor
    val textDark = TextDark

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        dragHandle = { /* optional */ },
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true) // like .medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            // Header
            PickerHeader(title = "App") {
                onDismissRequest()
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Amount input row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .border(1.dp, borderColor, RoundedCornerShape(10.dp))
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.attach_money),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // We keep text as string and parse to Double
                var amountText = remember(amount) { amount.toString() }

                TextField(
                    value = amountText,
                    onValueChange = {
                        amountText = it
                        it.toDoubleOrNull()?.let { value ->
                            onAmountChange(value)
                        }
                    },
                    placeholder = { Text("Amount") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
//                    colors = TextFieldDefaults.textFieldColors(
//                        containerColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent,
//                        disabledIndicatorColor = Color.Transparent,
//                        textColor = textDark
//                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}