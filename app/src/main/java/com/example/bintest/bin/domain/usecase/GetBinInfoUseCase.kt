package com.example.bintest.bin.domain.usecase

import com.example.bintest.bin.domain.model.BinInfo
import com.example.bintest.bin.domain.repository.BinInfoRepository
import javax.inject.Inject

class GetBinInfoUseCase @Inject constructor(private val repository: BinInfoRepository) {
    suspend operator fun invoke(id: Int): BinInfo {
        return repository.getBinInfo(id)
    }
}