package com.example.caratlane.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(navController: NavController){
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){ }
        composable("details") { }
    }
}