package com.example.bintest.bin.presentation.home_screen

import com.example.bintest.bin.domain.model.BinInfo

sealed class BinInfoViewState {
    data object Empty : BinInfoViewState()
    data object Loading : BinInfoViewState()
    data class Success(val binInfo: BinInfo) : BinInfoViewState()
    data class Error(val message: String) : BinInfoViewState()
}