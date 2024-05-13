package com.example.bintest.bin.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bintest.bin.data.local.dao.BinsDao
import com.example.bintest.bin.data.local.entity.BinInfoEntity

@Database(entities = [BinInfoEntity::class], version = 1, exportSchema = false)
abstract class BinsDataBase : RoomDatabase() {
    abstract fun binsDao(): BinsDao
}