package com.example.chargeback.data.model

import java.time.LocalDate
import java.util.UUID

data class Subscription(
    val id: UUID = UUID.randomUUID(),
    var appName: AppName,
    var amount: Double,
    var category: Category,
    var startDate: LocalDate,
    var frequency: Frequency,
    var remindMe: Reminder,
    var isActive: Boolean
)