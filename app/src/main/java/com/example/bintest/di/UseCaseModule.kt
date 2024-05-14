package com.example.bintest.di

import com.example.bintest.bin.domain.repository.BinInfoRepository
import com.example.bintest.bin.domain.usecase.GetBinInfoListUseCase
import com.example.bintest.bin.domain.usecase.GetBinInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetBinInfoUseCase(repository: BinInfoRepository): GetBinInfoUseCase {
        return GetBinInfoUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetBinInfoListUseCase(repository: BinInfoRepository): GetBinInfoListUseCase {
        return GetBinInfoListUseCase(repository)
    }
}