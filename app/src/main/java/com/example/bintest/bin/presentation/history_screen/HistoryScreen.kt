package com.example.bintest.bin.presentation.history_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.bintest.R
import com.example.bintest.bin.presentation.history_screen.components.HistoryContent

@Composable
fun HistoryScreen(
    historyViewModel: HistoryViewModel = hiltViewModel()
) {
    val state by historyViewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(R.string.history_screen_title))

        Spacer(modifier = Modifier.height(16.dp))

        when(state) {
            is HistoryViewState.Empty -> Text(text = stringResource(R.string.history_is_empty))
            is HistoryViewState.Loading -> Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            is HistoryViewState.Success -> HistoryContent(binInfoList = (state as HistoryViewState.Success).binInfoList)
            is HistoryViewState.Error -> Text(text = (state as HistoryViewState.Error).message)
        }
    }
}