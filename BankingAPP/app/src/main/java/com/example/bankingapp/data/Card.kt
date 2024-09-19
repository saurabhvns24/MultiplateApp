package com.example.bankingapp.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Card(
    val cardType: String,
    val cardNumber: String,
    val balance: Long,
    val cardName: String,
    val color: Brush
)