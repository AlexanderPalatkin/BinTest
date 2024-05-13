package com.example.bintest.bin.domain.model

data class BinInfo(
    val id: Int,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean,
    val countryAlpha: String,
    val countryName: String,
    val countryLat: Int,
    val countryLon: Int,
    val bankName: String,
    val bankUrl: String,
    val bankPhone: String,
    val bankCity: String,
    val numberLength: Int,
    val numberLuhn: Boolean
)