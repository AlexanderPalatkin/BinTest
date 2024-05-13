package com.example.bintest.bin.data.mapper

import com.example.bintest.bin.data.local.entity.BinInfoEntity
import com.example.bintest.bin.data.remote.model.BinInfoRemote
import com.example.bintest.bin.domain.model.BinInfo

fun BinInfoRemote.toBinInfo(id: Int): BinInfo =
    BinInfo(
        id = id,
        scheme = this.scheme.orEmpty(),
        type = this.type.orEmpty(),
        brand = this.brand.orEmpty(),
        prepaid = this.prepaid ?: false,
        countryAlpha = this.country?.alpha2.orEmpty(),
        countryName = this.country?.name.orEmpty(),
        countryLat = this.country?.latitude ?: 0,
        countryLon = this.country?.longitude ?: 0,
        bankName = this.bank?.name.orEmpty(),
        bankUrl = this.bank?.url.orEmpty(),
        bankPhone = this.bank?.phone.orEmpty(),
        bankCity = this.bank?.city.orEmpty(),
        numberLength = this.number?.length ?: 0,
        numberLuhn = this.number?.luhn ?: false
    )

fun BinInfoEntity.toBinInfo(): BinInfo =
    BinInfo(
        id = this.id,
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        countryAlpha = this.countryAlpha,
        countryName = this.countryName,
        countryLat = this.countryLat,
        countryLon = this.countryLon,
        bankName = this.bankName,
        bankUrl = this.bankUrl,
        bankPhone = this.bankPhone,
        bankCity = this.bankCity,
        numberLength = this.numberLength,
        numberLuhn = this.numberLuhn
    )

fun BinInfo.toBinInfoEntity(): BinInfoEntity =
    BinInfoEntity(
        id = this.id,
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        countryAlpha = this.countryAlpha,
        countryName = this.countryName,
        countryLat = this.countryLat,
        countryLon = this.countryLon,
        bankName = this.bankName,
        bankUrl = this.bankUrl,
        bankPhone = this.bankPhone,
        bankCity = this.bankCity,
        numberLength = this.numberLength,
        numberLuhn = this.numberLuhn
    )