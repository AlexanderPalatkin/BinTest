package com.example.bintest.bin.presentation.bottomnav

import com.example.bintest.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val iconFocused: Int
) {
    data object Home: BottomBarScreen(
        route = "home",
        title = "Add Card",
        icon = R.drawable.ic_new_card,
        iconFocused = R.drawable.ic_new_card
    )

    data object History: BottomBarScreen(
        route = "history",
        title = "History",
        icon = R.drawable.ic_history_card,
        iconFocused = R.drawable.ic_history_card
    )
}