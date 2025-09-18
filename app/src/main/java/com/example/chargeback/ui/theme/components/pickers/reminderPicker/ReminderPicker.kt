package com.example.chargeback.ui.theme.components.pickers.reminderPicker

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
import com.example.chargeback.data.model.Reminder
import com.example.chargeback.ui.theme.components.common.PickerHeader

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReminderPickerSheet(
    reminders: List<Reminder>,
    selectedReminder: Reminder,
    onReminderSelected: (Reminder) -> Unit,
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
            PickerHeader(title = "Remind Me") {
                onDismissRequest()
            }

            // Scrollable list of reminders
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .heightIn(max = 400.dp) // mimics medium/large detents
            ) {
                items(reminders) { reminder ->
                    ReminderPickerItem(
                        reminder = reminder,
                        selectedReminder = selectedReminder,
                        onReminderSelected = onReminderSelected
                    )
                }
            }
        }
    }
}