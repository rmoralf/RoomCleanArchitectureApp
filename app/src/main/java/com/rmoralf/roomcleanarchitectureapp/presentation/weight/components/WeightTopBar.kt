package com.rmoralf.roomcleanarchitectureapp.presentation.weight.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmoralf.roomcleanarchitectureapp.presentation.weight.WeightViewModel
import com.rmoralf.roomcleanarchitectureapp.R

@Composable
fun WeightTopBar(
    viewModel: WeightViewModel = hiltViewModel()
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.appbar_title))
        },
        actions = {
            IconButton(onClick = {
                viewModel.openDialogState.value = true
            }) {
                Icon(Icons.Default.Add, stringResource(id = R.string.appbar_add))
            }
            IconButton(onClick = {
                viewModel.clearWeights()
            }) {
                Icon(Icons.Default.Delete, stringResource(id = R.string.appbar_reset))
            }
        }
    )
}