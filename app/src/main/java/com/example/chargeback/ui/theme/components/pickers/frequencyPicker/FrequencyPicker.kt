package com.example.chargeback.ui.theme.components.pickers.frequencyPicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.Frequency
import com.example.chargeback.ui.theme.components.common.PickerHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FrequencyPickerSheet(
    frequencies: List<Frequency>,
    selectedFrequency: Frequency,
    onFrequencySelected: (Frequency) -> Unit,
    onDismissRequest: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        containerColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            // Header
            PickerHeader(title = "Frequency") {
                onDismissRequest()
            }

            // Scrollable list of frequencies
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .heightIn(max = 400.dp) // mimic medium/large detents
            ) {
                items(frequencies) { frequency ->
                    FrequencyPickerItem(
                        frequency = frequency,
                        selectedFrequency = selectedFrequency,
                        onFrequencySelected = onFrequencySelected
                    )
                }
            }
        }
    }
}