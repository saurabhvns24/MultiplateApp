package com.example.jetpackcompose.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.DataManager
import com.example.jetpackcompose.model.Quote

@Composable
fun QuoteDetail(quote: Quote) {
    BackHandler { DataManager.switchPages(null) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush
                    .sweepGradient(
                        colors = listOf(
                            Color(0xFFffffff),
                            Color(0xFFE3E3E3)
                        )
                    )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
//                    .align(alignment = Alignment.Center)
                    .padding(16.dp, 24.dp)

            ) {
                Image(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                )

                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(Modifier.height(16.dp))
                Text(
//                    modifier = Modifier.align(alignment = Alignment.BottomEnd),
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

    }
}