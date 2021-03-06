package com.rmoralf.roomcleanarchitectureapp.presentation.weight.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rmoralf.roomcleanarchitectureapp.R
import com.rmoralf.roomcleanarchitectureapp.presentation.theme.HeaderBg

@Composable
fun WeightListHeader() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(HeaderBg)
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.header_date),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = R.string.header_weight),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }

}