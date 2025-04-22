package com.mehmetpetek.basesampleapp.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mehmetpetek.basesampleapp.features.screen.favorite.FavoriteRoute

const val favoriteNavigationRoute = "favorite_route"

fun NavController.navigateFavorite(
    navOptions: NavOptions? = null
) {
    this.navigate(favoriteNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.favoriteScreen() {
    composable(route = favoriteNavigationRoute) {
        FavoriteRoute()
    }
}