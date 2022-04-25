package com.rmoralf.weightcontrol.presentation.weight

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rmoralf.weightcontrol.data.database.entitities.toDatabase
import com.rmoralf.weightcontrol.domain.model.Response
import com.rmoralf.weightcontrol.domain.model.Response.Loading
import com.rmoralf.weightcontrol.domain.model.Response.Success
import com.rmoralf.weightcontrol.domain.model.Weight
import com.rmoralf.weightcontrol.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeightViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    var openDialogState = mutableStateOf(false)

    private val _weightsState = mutableStateOf<Response<List<Weight>>>(Loading)
    val weightsState: State<Response<List<Weight>>> = _weightsState

    private val _isWeightAddedState = mutableStateOf<Response<Unit>>(Success(Unit))
    val isWeightAddedState: State<Response<Unit>> = _isWeightAddedState

    private val _isWeightDeletedState = mutableStateOf<Response<Unit>>(Success(Unit))
    val isWeightDeletedState: State<Response<Unit>> = _isWeightDeletedState

    init {
        getAllWeights()
    }

    private fun getAllWeights() {
        viewModelScope.launch {
            useCases.getDailyWeights.invoke().collect { response ->
                _weightsState.value = response
            }
        }
    }

    fun storeNewWeight(date: String, weight: String) {
        viewModelScope.launch {
            useCases.storeNewWeight.invoke(
                Weight(date = date, weight = weight).toDatabase()
            ).collect { response ->
                _isWeightAddedState.value = response
                if (response is Success)
                    getAllWeights()
            }
        }
    }

    fun clearWeights() {
        viewModelScope.launch {
            useCases.clearWeights.invoke().collect { response ->
                _isWeightDeletedState.value = response
                if (response is Success)
                    getAllWeights()
            }
        }
    }
}