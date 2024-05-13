package com.example.bintest.bin.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bintest.bin.data.util.Constant.BIN_TABLE

@Entity(tableName = BIN_TABLE)
data class BinInfoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "scheme")
    val scheme: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "brand")
    val brand: String,
    @ColumnInfo(name = "prepaid")
    val prepaid: Boolean,
    @ColumnInfo(name = "country_alpha")
    val countryAlpha: String,
    @ColumnInfo(name = "country_name")
    val countryName: String,
    @ColumnInfo(name = "country_lat")
    val countryLat: Int,
    @ColumnInfo(name = "country_lon")
    val countryLon: Int,
    @ColumnInfo(name = "bank_name")
    val bankName: String,
    @ColumnInfo(name = "bank_url")
    val bankUrl: String,
    @ColumnInfo(name = "bank_phone")
    val bankPhone: String,
    @ColumnInfo(name = "bank_city")
    val bankCity: String,
    @ColumnInfo(name = "number_length")
    val numberLength: Int,
    @ColumnInfo(name = "number_luhn")
    val numberLuhn: Boolean
)