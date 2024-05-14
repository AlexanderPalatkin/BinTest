package com.example.bintest.bin.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.bintest.bin.data.local.entity.BinInfoEntity
import com.example.bintest.bin.data.util.Constant.BIN_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface BinsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBinInfo(binInfoEntity: BinInfoEntity)

    @Query("SELECT * FROM $BIN_TABLE")
    fun getBinInfoList(): Flow<List<BinInfoEntity>>
}