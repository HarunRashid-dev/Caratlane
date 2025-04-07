package com.example.caratlane.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(val route: String, val icon: ImageVector, val label: String){
    object Home : BottomNavItems("home", Icons.Filled.Home, "Home")
    object Categories : BottomNavItems("categories", Icons.Filled.Category, "Categories")
}