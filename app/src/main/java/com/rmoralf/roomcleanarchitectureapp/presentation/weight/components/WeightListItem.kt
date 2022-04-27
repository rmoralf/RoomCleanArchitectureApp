package com.rmoralf.roomcleanarchitectureapp.presentation.weight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rmoralf.roomcleanarchitectureapp.domain.model.Weight

@Composable
fun WeightListItem(
    weight: Weight
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = weight.date,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = weight.weight,
        )
    }
}