package com.example.bintest.bin.presentation.history_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bintest.R
import com.example.bintest.bin.domain.model.BinInfo

@Composable
fun BinInfoCard(
    binInfo: BinInfo,
    onLatLonClick: (lat: Double, lon: Double) -> Unit,
    onBankPhoneClick: (phone: String) -> Unit,
    onBankUrlClick: (url: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(R.string.bin_information, binInfo.id),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(
                    R.string.scheme,
                    binInfo.scheme.replaceFirstChar { it.uppercase() })
            )
            Text(
                text = stringResource(
                    R.string.type,
                    binInfo.type.replaceFirstChar { it.uppercase() })
            )
            Text(text = stringResource(R.string.brand, binInfo.brand))
            Text(
                text = stringResource(
                    R.string.prepaid,
                    if (binInfo.prepaid) stringResource(R.string.yes) else stringResource(R.string.no)
                )
            )
            Text(text = stringResource(R.string.country_alpha, binInfo.countryAlpha))
            Text(text = stringResource(R.string.country_name, binInfo.countryName))
            Text(
                modifier = Modifier.clickable {
                    onLatLonClick(binInfo.countryLat.toDouble(), binInfo.countryLon.toDouble())
                },
                text = stringResource(
                    R.string.country_lat_lon,
                    binInfo.countryLat,
                    binInfo.countryLon
                )
            )
            Text(text = stringResource(R.string.bank_name, binInfo.bankName))
            Text(
                modifier = Modifier.clickable {
                    if (binInfo.bankPhone.isNotEmpty()) {
                        onBankPhoneClick(binInfo.bankPhone)
                    }
                },
                text = stringResource(R.string.bank_phone, binInfo.bankPhone)
            )
            Text(modifier = Modifier.clickable {
                if (binInfo.bankUrl.isNotEmpty()) {
                    onBankUrlClick(binInfo.bankUrl)
                }
            }, text = stringResource(R.string.bank_url, binInfo.bankUrl))
            Text(text = stringResource(R.string.bank_city, binInfo.bankCity))
            Text(text = stringResource(R.string.number_length, binInfo.numberLength))
            Text(
                text = stringResource(
                    R.string.number_luhn,
                    if (binInfo.numberLuhn) stringResource(R.string.yes) else stringResource(R.string.no)
                )
            )
        }
    }
}