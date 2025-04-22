package com.mehmetpetek.basesampleapp.features.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mehmetpetek.basesampleapp.features.screen.profile.ProfileRoute

const val profileNavigationRoute = "profile_route"

fun NavController.navigateProfile(
    navOptions: NavOptions? = null
) {
    this.navigate(profileNavigationRoute, navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.profileScreen() {
    composable(route = profileNavigationRoute) {
        ProfileRoute()
    }
}