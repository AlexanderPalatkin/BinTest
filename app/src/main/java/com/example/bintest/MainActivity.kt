package com.example.bintest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bintest.bin.presentation.MainScreen
import com.example.bintest.ui.theme.BinTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BinTestTheme {
                MainScreen(
                    onLatLonClick = { lat, lon ->
                        openMap(lat, lon)
                    },
                    onBankPhoneClick = { phone ->
                        callPhone(phone)
                    },
                    onBankUrlClick = { url ->
                        openBrowser(url)
                    })
            }
        }
    }

    private fun openMap(latitude: Double, longitude: Double) {
        val gmmIntentUri = Uri.parse("geo:$latitude,$longitude")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            val browserIntentUri =
                Uri.parse("https://www.google.com/maps/search/?api=1&query=$latitude,$longitude")
            val browserIntent = Intent(Intent.ACTION_VIEW, browserIntentUri)
            startActivity(browserIntent)
        }
    }

    private fun callPhone(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)
    }

    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}