package com.example.bintest.bin.presentation.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bintest.bin.presentation.history_screen.HistoryScreen
import com.example.bintest.bin.presentation.home_screen.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.History.route) {
            HistoryScreen()
        }
    }
}