package com.example.bintest.di

import android.content.Context
import androidx.room.Room
import com.example.bintest.bin.data.local.BinsDataBase
import com.example.bintest.bin.data.remote.api.BinsApi
import com.example.bintest.bin.data.util.Constant.BASE_URL
import com.example.bintest.di.constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideBinInfoApi(): BinsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BinsDataBase::class.java, DB_NAME)
            .build()

    @Provides
    @Singleton
    fun provideBinsDao(db: BinsDataBase) = db.binsDao()
}