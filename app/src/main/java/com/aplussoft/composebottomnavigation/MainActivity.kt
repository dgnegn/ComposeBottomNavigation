@file:OptIn(ExperimentalMaterial3Api::class)

package com.aplussoft.composebottomnavigation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastAny
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.aplussoft.composebottomnavigation.ui.screens.Destination
import com.aplussoft.composebottomnavigation.ui.screens.bottomNavItems
import com.aplussoft.composebottomnavigation.ui.screens.categories.Categories
import com.aplussoft.composebottomnavigation.ui.screens.favorites.Favorites
import com.aplussoft.composebottomnavigation.ui.screens.notes.NoteDetails
import com.aplussoft.composebottomnavigation.ui.screens.notes.Notes
import com.aplussoft.composebottomnavigation.ui.screens.search.Search
import com.aplussoft.composebottomnavigation.ui.screens.settings.Settings
import com.aplussoft.composebottomnavigation.ui.theme.ComposeBottomNavigationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomNavigationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavHost()
                }
            }
        }
    }
}

@Composable
fun MyNavHost() {
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val isCurrentDestination =
                bottomNavItems.fastAny { item -> currentDestination?.hasRoute(item.route::class) == true }

            if (isCurrentDestination)
                NavigationBar {
                    bottomNavItems.forEach { item ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                            },
                            label = { Text(text = item.title) },
                            selected = currentDestination?.hasRoute(item.route::class) == true,
                            onClick = {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }

        }
    ) {

        NavHost(
            navController = navController,
            startDestination = Destination.Notes,
            modifier = Modifier.padding(it)
        ) {
            composable<Destination.Notes> {
                Notes(
                    onNavigateToNoteDetails = { noteId ->
                        navController.navigate(Destination.NoteDetails(noteId))
                    }
                )
            }
            composable<Destination.NoteDetails> { backStackEntry ->
                val noteDetails = backStackEntry.toRoute<Destination.NoteDetails>()
                NoteDetails(
                    noteId = noteDetails.noteId,
                    onNavigateToBack = {
                        navController.popBackStack()
                    }
                )

            }
            composable<Destination.Favorites> { Favorites() }
            composable<Destination.Search> { Search() }
            composable<Destination.Categories> { Categories() }
            composable<Destination.Settings> { Settings() }
        }
    }
}
