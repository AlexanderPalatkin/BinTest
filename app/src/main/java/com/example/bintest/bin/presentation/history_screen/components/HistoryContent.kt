package com.example.bintest.bin.presentation.history_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.bintest.bin.domain.model.BinInfo

@Composable
fun HistoryContent(binInfoList: List<BinInfo>) {
    LazyColumn {
        items(binInfoList) { binInfo ->
            BinInfoCard(binInfo)
        }
    }
}