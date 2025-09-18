package com.example.chargeback

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.chargeback.data.model.AppName
import com.example.chargeback.data.model.Category
import com.example.chargeback.data.model.Frequency
import com.example.chargeback.data.model.Reminder
import com.example.chargeback.data.model.Subscription
import com.example.chargeback.ui.theme.ChargebackTheme
import com.example.chargeback.ui.theme.components.screens.EditSubscriptionScreen
import com.example.chargeback.viewmodel.EditSubscriptionViewModel
import java.time.LocalDate

class MainActivity : ComponentActivity() {

    // You can use viewModels() for lifecycle-aware ViewModel
    private val viewModel: EditSubscriptionViewModel by lazy {
        EditSubscriptionViewModel(
            Subscription(
                appName = AppName.NETFLIX,
                amount = 12.99,
                category = Category.SUBSCRIPTION,
                startDate = LocalDate.now(),
                frequency = Frequency.MONTHLY,
                remindMe = Reminder.SAME_DAY,
                isActive = true
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChargebackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EditSubscriptionScreen(
                        viewModel = viewModel,
                        onDismiss = { finish() } // closes the activity
                    )
                }
            }
        }
    }
}