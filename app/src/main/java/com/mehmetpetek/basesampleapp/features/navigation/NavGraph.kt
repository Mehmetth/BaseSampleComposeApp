package com.mehmetpetek.basesampleapp.features.navigation


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mehmetpetek.basesampleapp.common.helper.toJson
import com.mehmetpetek.basesampleapp.features.component.BaseSampleAppBottomAppBar
import com.mehmetpetek.basesampleapp.features.screen.splash.SplashRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination


    var showSplashScreen by remember { mutableStateOf(true) }


    if (showSplashScreen) {
        SplashRoute {
            showSplashScreen = false
        }
    } else {
        Scaffold(
            bottomBar = {
                BottomNav.entries.forEach { navItem ->
                    if (navItem.route == currentRoute) {
                        BaseSampleAppBottomAppBar(
                            navController = navController,
                            currentDestination = currentDestination
                        )
                    }
                }
            },
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = homeNavigationRoute,
                Modifier.padding(innerPadding)
            ) {
                homeScreen {
                    navController.navigateToMemeDetail(it.toJson())
                }
                favoriteScreen()
                profileScreen()
                memeDetailScreen()
            }
        }
    }
}