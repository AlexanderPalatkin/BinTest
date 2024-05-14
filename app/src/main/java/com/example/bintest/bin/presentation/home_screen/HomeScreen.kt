package com.example.bintest.bin.presentation.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bintest.R
import com.example.bintest.bin.presentation.home_screen.components.BinInfoHomeCard

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val state by homeViewModel.binInfoState.collectAsStateWithLifecycle()

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(modifier = Modifier.fillMaxSize()) {
        val binNumber = remember {
            mutableStateOf("")
        }

        TextField(
            value = binNumber.value,
            onValueChange = {
                if (it.isEmpty() || (it.all { char -> char.isDigit() } && it.length <= 8)) {
                    binNumber.value = it
                }
            },
            label = { Text(stringResource(R.string.label_bin_number_field)) },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    if (binNumber.value.length == 8) {
                        homeViewModel.getBinInfo(binNumber.value)
                    }
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                keyboardController?.hide()
                homeViewModel.getBinInfo(binNumber.value) },
            modifier = Modifier.fillMaxWidth(),
            enabled = binNumber.value.length == 8
        ) {
            Text(stringResource(R.string.submit))
        }

        Spacer(modifier = Modifier.height(30.dp))

        when(state) {
            is BinInfoViewState.Loading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            is BinInfoViewState.Success -> BinInfoHomeCard(binInfo = (state as BinInfoViewState.Success).binInfo)
            is BinInfoViewState.Error -> Text(text = stringResource(
                R.string.error_home_screen,
                (state as BinInfoViewState.Error).message
            ))
            is BinInfoViewState.Empty -> Text(text = stringResource(R.string.empty_home_screen))
        }
    }
}