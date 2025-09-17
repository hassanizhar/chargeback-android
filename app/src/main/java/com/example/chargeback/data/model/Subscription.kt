package com.example.chargeback.data.model

import java.util.UUID
import java.util.Date // Or java.time.LocalDate if you prefer

data class Subscription(
    val id: UUID = UUID.randomUUID(),
    var appName: AppName,
    var amount: Double,
    var category: Category,
    var startDate: Date,
    var frequency: Frequency,
    var remindMe: Reminder,
    var isActive: Boolean
)