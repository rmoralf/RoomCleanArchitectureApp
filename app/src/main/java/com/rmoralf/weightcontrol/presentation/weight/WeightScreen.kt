package com.rmoralf.weightcontrol.presentation.weight

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmoralf.weightcontrol.R
import com.rmoralf.weightcontrol.core.utils.Constants.TAG
import com.rmoralf.weightcontrol.domain.model.Response.*
import com.rmoralf.weightcontrol.presentation.components.ProgressBar
import com.rmoralf.weightcontrol.presentation.weight.components.AddWeightDialog
import com.rmoralf.weightcontrol.presentation.weight.components.WeightListHeader
import com.rmoralf.weightcontrol.presentation.weight.components.WeightListItem
import com.rmoralf.weightcontrol.presentation.weight.components.WeightTopBar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeightScreen(
    viewModel: WeightViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            WeightTopBar()
        }
    ) {
        if (viewModel.openDialogState.value) {
            AddWeightDialog()
        }
        when (val weightResponse = viewModel.weightsState.value) {
            is Loading -> ProgressBar()
            is Success -> Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(White)
                ) {
                    if (weightResponse.data.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.empty_weights),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .align(Alignment.TopCenter)
                        )
                        {
                            stickyHeader {
                                WeightListHeader()
                            }
                            items(weightResponse.data) { item ->
                                WeightListItem(item)
                            }
                        }
                    }
                }
            }
            is Error -> Log.d(TAG, weightResponse.message)
        }

        when (val additionResponse = viewModel.isWeightAddedState.value) {
            is Loading -> ProgressBar()
            is Success -> Unit
            is Error -> Log.d(TAG, additionResponse.message)
        }

        when (val deletionResponse = viewModel.isWeightDeletedState.value) {
            is Loading -> ProgressBar()
            is Success -> Unit
            is Error -> Log.d(TAG, deletionResponse.message)
        }

    }
}
