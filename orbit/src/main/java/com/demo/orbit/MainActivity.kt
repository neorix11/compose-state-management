package com.demo.orbit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.demo.composables.Screen
import com.demo.composables.bottomNavigationItems
import com.demo.composables.components.MovieBottomNavigation
import com.demo.orbit.views.MovieSearchView
import com.demo.orbit.views.WatchListView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainLayout() }
    }
}


@Composable
fun MainLayout() {

    val navController = rememberNavController()

    MaterialTheme {
        Scaffold(
            bottomBar =  {
                BottomAppBar(
                    cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50))
                ) {

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route

                    bottomNavigationItems.forEach { bottomNavigationItem ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    bottomNavigationItem.icon,
                                    contentDescription = bottomNavigationItem.iconDescription
                                )
                            },
                            label = { Text(bottomNavigationItem.iconDescription) },
                            selected = currentRoute == bottomNavigationItem.route,
                            onClick = {
                                navController.navigate(bottomNavigationItem.route) {
                                    popUpTo(navController.graph.id)
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        ) { paddingValues ->
            Box(Modifier.padding(paddingValues)) {
                NavHost(navController = navController, startDestination = Screen.MovieSearch.title) {
                    composable(Screen.MovieSearch.title) {
                        MovieSearchView()
                    }
                    composable(Screen.WatchList.title) {
                        WatchListView()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainLayout()
}