package com.example.bintest.di

import com.example.bintest.bin.data.local.dao.BinsDao
import com.example.bintest.bin.data.remote.api.BinsApi
import com.example.bintest.bin.data.repository.BinInfoRepositoryImpl
import com.example.bintest.bin.domain.repository.BinInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBinInfoRepository(binsApi: BinsApi, binsDao: BinsDao): BinInfoRepository {
        return BinInfoRepositoryImpl(binsApi, binsDao)
    }
}