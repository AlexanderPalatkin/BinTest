package com.example.bintest.bin.presentation.history_screen.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.bintest.bin.domain.model.BinInfo

@Composable
fun HistoryContent(
    binInfoList: List<BinInfo>,
    onLatLonClick: (lat: Double, lon: Double) -> Unit,
    onBankPhoneClick: (phone: String) -> Unit,
    onBankUrlClick: (url: String) -> Unit
) {
    LazyColumn {
        items(binInfoList) { binInfo ->
            BinInfoCard(binInfo, onLatLonClick, onBankPhoneClick, onBankUrlClick)
        }
    }
}