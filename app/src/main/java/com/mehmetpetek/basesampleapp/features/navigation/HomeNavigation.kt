package com.mehmetpetek.basesampleapp.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mehmetpetek.basesampleapp.data.remote.Memes
import com.mehmetpetek.basesampleapp.features.screen.home.HomeRoute

const val homeNavigationRoute = "home_route"

fun NavController.navigateHome(
    navOptions: NavOptions? = null
) {
    this.navigate(homeNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.homeScreen(
    navigateToMemeDetail: (Memes) -> Unit
) {
    composable(route = homeNavigationRoute) {
        HomeRoute(
            navigateToMemeDetail = navigateToMemeDetail
        )
    }
}