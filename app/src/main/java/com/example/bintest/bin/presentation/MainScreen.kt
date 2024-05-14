package com.example.bintest.bin.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.bintest.bin.presentation.bottomnav.BottomBar
import com.example.bintest.bin.presentation.bottomnav.BottomNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(navController = navController)
            }
        ) {
            Box(modifier = Modifier.padding(it)) {
                BottomNavGraph(navController = navController)
            }
        }
    }
}