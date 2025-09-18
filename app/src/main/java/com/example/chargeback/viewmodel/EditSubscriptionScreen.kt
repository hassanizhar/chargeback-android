package com.example.chargeback.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chargeback.data.model.AppName
import com.example.chargeback.data.model.Category
import com.example.chargeback.data.model.Frequency
import com.example.chargeback.data.model.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.chargeback.data.model.Subscription
import kotlinx.coroutines.flow.isActive
import java.time.LocalDate

class EditSubscriptionViewModel(subscription: Subscription) : ViewModel() {

    // Internal mutable state
    private val _subscription = MutableStateFlow(subscription)

    // Public read-only state for Compose
    val subscription = _subscription.asStateFlow()

    // Update subscription
    fun updateSubscription(updated: Subscription) {
        _subscription.value = updated
    }

    // Update individual fields
    fun updateApp(app: AppName) {
        _subscription.value = _subscription.value.copy(appName = app)
    }

    fun updateAmount(amount: Double) {
        _subscription.value = _subscription.value.copy(amount = amount)
    }

    fun updateCategory(category: Category) {
        _subscription.value = _subscription.value.copy(category = category)
    }

    fun updateFrequency(frequency: Frequency) {
        _subscription.value = _subscription.value.copy(frequency = frequency)
    }

    fun updateReminder(reminder: Reminder) {
        _subscription.value = _subscription.value.copy(remindMe = reminder)
    }

    fun updateStartDate(date: LocalDate) {
        _subscription.value = _subscription.value.copy(startDate = date)
    }

    fun updateIsActive(isActive: Boolean) {
        _subscription.value = _subscription.value.copy(isActive = isActive)
    }

    fun save() {
        // implement save logic (Room DB, API, etc.)
        println("Saved ${_subscription.value}")
    }

    fun delete() {
        // implement delete logic
        println("Deleted subscription")
    }
}