package com.example.caratlane.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(val route: String, val icon: ImageVector, val label: String){
    object Home : BottomNavItems("home", Icons.Filled.Home, "Home")
    object Categories : BottomNavItems("categories", Icons.Filled.Category, "Categories")
    object popi : BottomNavItems("popi", Icons.Filled.Search, "popi")
    object FindStore : BottomNavItems("find_store", Icons.Filled.Place, "Find Store")
    object You : BottomNavItems("you", Icons.Filled.Person, "You")
}


val bottomNavItems = listOf(
    BottomNavItems.Home,
    BottomNavItems.Categories,
    BottomNavItems.popi,
    BottomNavItems.FindStore,
    BottomNavItems.You
)