package com.aplussoft.composebottomnavigation.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable


@Serializable
sealed class Destination {
    @Serializable
    object Notes : Destination()

    @Serializable
    data class NoteDetails(val noteId: Int) : Destination()

    @Serializable
    object Favorites : Destination()

    @Serializable
    object Search : Destination()

    @Serializable
    object Categories : Destination()

    @Serializable
    object Settings : Destination()
}

data class NavigationItem(
    val route: Destination,
    val title: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    NavigationItem(Destination.Notes, "Notes", Icons.Default.Home),
    NavigationItem(Destination.Favorites, "Favorites", Icons.Default.Favorite),
    NavigationItem(Destination.Search, "Search", Icons.Default.Search),
    NavigationItem(Destination.Categories, "Categories", Icons.Default.Category),
    NavigationItem(Destination.Settings, "Settings", Icons.Default.Settings)
)
