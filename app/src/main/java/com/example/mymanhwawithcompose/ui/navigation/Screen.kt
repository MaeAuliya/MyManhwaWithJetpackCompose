package com.example.mymanhwawithcompose.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Profile: Screen("profile")
    object DetailManhwa: Screen("home/{manhwaId}"){
        fun createRoute(manhwaId: Int) = "home/$manhwaId"
    }
}