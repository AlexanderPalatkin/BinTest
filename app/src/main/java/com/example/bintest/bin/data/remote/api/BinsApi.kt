package com.example.bintest.bin.data.remote.api

import com.example.bintest.bin.data.remote.model.BinInfoRemote
import retrofit2.http.GET
import retrofit2.http.Path

interface BinsApi {

    @GET("{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfoRemote
}