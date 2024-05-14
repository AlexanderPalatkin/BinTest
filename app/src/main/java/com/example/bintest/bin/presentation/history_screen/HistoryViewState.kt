package com.example.bintest.bin.presentation.history_screen

import com.example.bintest.bin.domain.model.BinInfo

sealed class HistoryViewState {

    data object Empty : HistoryViewState()
    data object Loading : HistoryViewState()

    data class Success(val binInfoList: List<BinInfo>) : HistoryViewState()

    data class Error(val message: String) : HistoryViewState()
}