package com.example.bintest.bin.domain.usecase

import com.example.bintest.bin.domain.model.BinInfo
import com.example.bintest.bin.domain.repository.BinInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBinInfoListUseCase @Inject constructor(private val repository: BinInfoRepository) {
    operator fun invoke(): Flow<List<BinInfo>> {
        return repository.getBinInfoList()
    }
}