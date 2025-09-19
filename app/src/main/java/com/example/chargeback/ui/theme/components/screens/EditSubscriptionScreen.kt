package com.example.chargeback.ui.theme.components.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chargeback.data.model.AppName
import com.example.chargeback.data.model.Category
import com.example.chargeback.data.model.Frequency
import com.example.chargeback.data.model.Reminder
import com.example.chargeback.ui.theme.components.SubscriptionCardView
import com.example.chargeback.ui.theme.components.common.CustomRow
import com.example.chargeback.ui.theme.components.common.CustomTopBar
import com.example.chargeback.ui.theme.components.pickers.amountPicker.AmountPickerSheet
import com.example.chargeback.ui.theme.components.pickers.appPicker.AppPickerSheet
import com.example.chargeback.ui.theme.components.pickers.categoryPicker.CategoryPickerSheet
import com.example.chargeback.ui.theme.components.pickers.frequencyPicker.FrequencyPickerSheet
import com.example.chargeback.ui.theme.components.pickers.reminderPicker.ReminderPickerSheet
import com.example.chargeback.ui.theme.components.sections.amountSection.AmountSection
import com.example.chargeback.ui.theme.components.sections.appSection.AppSection
import com.example.chargeback.ui.theme.components.sections.categorySection.CategorySection
import com.example.chargeback.ui.theme.components.sections.dateSection.DateSection
import com.example.chargeback.ui.theme.components.sections.frequencySection.FrequencySection
import com.example.chargeback.ui.theme.components.sections.reminderSection.ReminderSection
import com.example.chargeback.viewmodel.EditSubscriptionViewModel
import kotlinx.coroutines.launch

import androidx.compose.material3.*
import androidx.compose.material3.rememberDatePickerState
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSubscriptionScreen(
    viewModel: EditSubscriptionViewModel,
    onDismiss: () -> Unit
) {
    val subscription by viewModel.subscription.collectAsState()

    var showAppSheet by remember { mutableStateOf(false) }
    var showAmountSheet by remember { mutableStateOf(false) }
    var showCategorySheet by remember { mutableStateOf(false) }
    var showFrequencySheet by remember { mutableStateOf(false) }
    var showReminderSheet by remember { mutableStateOf(false) }

    val allApps = AppName.entries
    val allCategories = Category.entries
    val allFrequencies = Frequency.entries
    val allReminders = Reminder.entries

    var showDatePickerDialog by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    Scaffold(
        topBar = {
            CustomTopBar(
                onDismiss = onDismiss,
                onSave = {
                    viewModel.save()
                    onDismiss()
                }
            )
        },
        containerColor = Color(0xFFF5F5F5) // ScreenBackground
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SubscriptionCardView(subscription = subscription)

            // First section: App, Amount, Category
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                AppSection(subscription.appName) { showAppSheet = true }
                AmountSection(subscription.amount) { showAmountSheet = true }
                CategorySection(subscription.category) { showCategorySheet = true }
            }

            // Second section: Date, Frequency, Reminder, Active toggle
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DateSection(subscription.startDate, onDateClick = {
                    showDatePickerDialog = true
                })
                FrequencySection(subscription.frequency) { showFrequencySheet = true }
                ReminderSection(subscription.remindMe) { showReminderSheet = true }


                CustomRow(
                    label = "Active",
                    onClick = null,
                    showDivider = false,
                    valueContent = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Switch(
                                checked = subscription.isActive,
                                onCheckedChange = { viewModel.updateIsActive(it) },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = Color.Green,
                                    uncheckedThumbColor = Color.White,
                                    uncheckedTrackColor = Color.LightGray,
                                    checkedBorderColor = Color.Transparent,
                                    uncheckedBorderColor = Color.Transparent,
                                    uncheckedIconColor = Color.Gray,
                                    checkedIconColor = Color.White
                                )

                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                )
            }

            // Delete button
            Button(
                onClick = {
                    viewModel.delete()
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp), // 👈 rounded corners
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp) // 👈 fixed height
            ) {
                Text(
                    "Delete",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Bottom sheets
        if (showAppSheet) {
            AppPickerSheet(
                apps = allApps,
                selectedApp = subscription.appName,
                onAppSelected = {
                    viewModel.updateApp(it)
                    showAppSheet = false
                },
                onDismissRequest = { showAppSheet = false }
            )
        }

        if (showAmountSheet) {
            AmountPickerSheet(
                amount = subscription.amount,
                onAmountChange = {
                    viewModel.updateAmount(it)
                    showAmountSheet = false
                },
                onDismissRequest = { showAmountSheet = false }
            )
        }

        if (showCategorySheet) {
            CategoryPickerSheet(
                categories = allCategories,
                selectedCategory = subscription.category,
                onCategorySelected = {
                    viewModel.updateCategory(it)
                    showCategorySheet = false
                },
                onDismissRequest = { showCategorySheet = false }
            )
        }

        if (showFrequencySheet) {
            FrequencyPickerSheet(
                frequencies = allFrequencies,
                selectedFrequency = subscription.frequency,
                onFrequencySelected = {
                    viewModel.updateFrequency(it)
                    showFrequencySheet = false
                },
                onDismissRequest = { showFrequencySheet = false }
            )
        }

        if (showReminderSheet) {
            ReminderPickerSheet(
                reminders = allReminders,
                selectedReminder = subscription.remindMe,
                onReminderSelected = {
                    viewModel.updateReminder(it)
                    showReminderSheet = false
                },
                onDismissRequest = { showReminderSheet = false }
            )
        }

        if (showDatePickerDialog) {
            DatePickerDialog(
                onDismissRequest = { showDatePickerDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        // when user clicks OK, update the viewmodel
                        datePickerState.selectedDateMillis?.let { millis ->
                            val localDate = Instant.ofEpochMilli(millis)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()
                            viewModel.updateStartDate(localDate) // pass LocalDate now
                        }
                        showDatePickerDialog = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDatePickerDialog = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}
