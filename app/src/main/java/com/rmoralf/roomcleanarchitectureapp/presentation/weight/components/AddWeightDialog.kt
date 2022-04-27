package com.rmoralf.roomcleanarchitectureapp.presentation.weight.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rmoralf.roomcleanarchitectureapp.presentation.weight.WeightViewModel
import com.rmoralf.roomcleanarchitectureapp.R
import java.util.*

@Composable
fun AddWeightDialog(
    viewModel: WeightViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val calYear: Int
    val calMonth: Int
    val calDay: Int

    val calendar = Calendar.getInstance()
    calYear = calendar.get(Calendar.YEAR)
    calMonth = calendar.get(Calendar.MONTH)
    calDay = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("$calDay/${calMonth + 1}/$calYear") }
    var weight by remember { mutableStateOf("") }

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month + 1}/$year"
        }, calYear, calMonth, calDay
    )

    if (viewModel.openDialogState.value) {
        AlertDialog(
            onDismissRequest = {
                viewModel.openDialogState.value = false
            },
            title = {
                Text(
                    text = stringResource(id = R.string.dialog_title)
                )
            },
            text = {
                Column {
                    Text(
                        text = date.value,
                        modifier = Modifier.clickable {
                            datePickerDialog.show()
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = weight,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = { weight = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.dialog_weight)
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (weight.isNotEmpty()) {
                            viewModel.openDialogState.value = false
                            viewModel.storeNewWeight(date = date.value, weight = weight)
                        }
                    },
                    enabled = date.value.isNotBlank()
                ) {
                    Text(
                        text = stringResource(id = R.string.dialog_add)
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        viewModel.openDialogState.value = false
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.dialog_cancel)
                    )
                }
            }
        )
    }
}