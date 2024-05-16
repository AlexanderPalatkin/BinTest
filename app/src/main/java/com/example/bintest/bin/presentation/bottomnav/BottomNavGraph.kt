package com.example.bintest.bin.presentation.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bintest.bin.presentation.history_screen.HistoryScreen
import com.example.bintest.bin.presentation.home_screen.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    onLatLonClick: (lat: Double, lon: Double) -> Unit,
    onBankPhoneClick: (phone: String) -> Unit,
    onBankUrlClick: (url: String) -> Unit
) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(
                onLatLonClick = onLatLonClick,
                onBankPhoneClick = onBankPhoneClick,
                onBankUrlClick = onBankUrlClick
            )
        }
        composable(route = BottomBarScreen.History.route) {
            HistoryScreen(
                onLatLonClick = onLatLonClick,
                onBankPhoneClick = onBankPhoneClick,
                onBankUrlClick = onBankUrlClick
            )
        }
    }
}