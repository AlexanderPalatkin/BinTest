package com.example.bintest.bin.presentation.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bintest.bin.domain.usecase.GetBinInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetBinInfoUseCase
) : ViewModel() {

    private val _binInfoState = MutableStateFlow<BinInfoViewState>(BinInfoViewState.Empty)
    val binInfoState: StateFlow<BinInfoViewState> = _binInfoState.asStateFlow()
    fun getBinInfo(bin: String) {
        viewModelScope.launch {
            _binInfoState.value = BinInfoViewState.Loading
            try {
                val binInfo = useCase(bin.toInt())
                _binInfoState.value = BinInfoViewState.Success(binInfo)
            } catch (e: Exception) {
                _binInfoState.value = BinInfoViewState.Error(e.message ?: "Unknown error")
            }
        }
    }
}