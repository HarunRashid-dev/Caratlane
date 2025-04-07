package com.example.caratlane.ui.theme

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.Navigator
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController){
    val items = listOf(
        BottomNavItems.Home,
        BottomNavItems.Categories,
        BottomNavItems.popi,
        BottomNavItems.FindStore,
        BottomNavItems.You
    )

    NavigationBar(
        containerColor = Color.White
    ){
        val currentDestination = navController.currentBackStackEntryAsState().value?.destination

        items.forEach { item ->
            NavigationBarItem(
                icon = {Icon(imageVector = item.icon, contentDescription = item.label)},
                label = {Text(item.label)},
                selected = currentDestination?.route == item.route,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}