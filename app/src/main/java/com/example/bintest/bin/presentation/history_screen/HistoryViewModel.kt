package com.example.bintest.bin.presentation.history_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bintest.bin.domain.usecase.GetBinInfoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val useCase: GetBinInfoListUseCase
) : ViewModel(){

    private val _state = MutableStateFlow<HistoryViewState>(HistoryViewState.Loading)
    val state: StateFlow<HistoryViewState> = _state.asStateFlow()

    init {
        getAllBinInfo()
    }

    private fun getAllBinInfo() {
        viewModelScope.launch {
            try {
                useCase().collect{binInfoList ->
                    if (binInfoList.isEmpty()) {
                        _state.value = HistoryViewState.Empty
                    } else {
                        _state.value = HistoryViewState.Success(binInfoList)
                    }
                }
            } catch (e: Exception) {
                _state.value = HistoryViewState.Error(e.message ?: "Unknown error")
            }
        }
    }
}