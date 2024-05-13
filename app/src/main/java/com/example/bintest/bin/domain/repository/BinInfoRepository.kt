package com.example.bintest.bin.domain.repository

import com.example.bintest.bin.domain.model.BinInfo
import kotlinx.coroutines.flow.Flow

interface BinInfoRepository {
    suspend fun getBinInfo(id: Int): BinInfo
    fun getAllBinInfo(): Flow<List<BinInfo>>
}