package com.example.bintest.di

import com.example.bintest.bin.data.repository.BinInfoRepositoryImpl
import com.example.bintest.bin.domain.repository.BinInfoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class BinInfoRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBinInfoRepository(impl: BinInfoRepositoryImpl): BinInfoRepository
}