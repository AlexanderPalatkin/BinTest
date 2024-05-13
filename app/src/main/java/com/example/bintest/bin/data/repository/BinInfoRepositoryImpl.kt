package com.example.bintest.bin.data.repository

import com.example.bintest.bin.data.local.dao.BinsDao
import com.example.bintest.bin.data.mapper.toBinInfo
import com.example.bintest.bin.data.mapper.toBinInfoEntity
import com.example.bintest.bin.data.remote.api.BinsApi
import com.example.bintest.bin.domain.model.BinInfo
import com.example.bintest.bin.domain.repository.BinInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject

class BinInfoRepositoryImpl @Inject constructor(
    private val binsApi: BinsApi,
    private val binsDao: BinsDao
) : BinInfoRepository {
    override suspend fun getBinInfo(id: Int): BinInfo {
        val binInfo = binsApi.getBinInfo(id.toString()).toBinInfo(id)
        binsDao.addBinInfo(binInfo.toBinInfoEntity())
        return binInfo
    }

    override fun getAllBinInfo(): Flow<List<BinInfo>> {
        return binsDao.getAllBinInfo().mapNotNull { binInfoEntityList ->
            binInfoEntityList.map { binInfoEntity ->
                binInfoEntity.toBinInfo()
            }
        }
    }
}