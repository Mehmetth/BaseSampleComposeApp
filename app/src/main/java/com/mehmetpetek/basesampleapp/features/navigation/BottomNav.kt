package com.mehmetpetek.basesampleapp.features.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.mehmetpetek.basesampleapp.R

enum class BottomNav(
    val route: String,
    @DrawableRes val iconId: Int,
    @StringRes val titleTextId: Int
) {
    HOME(
        homeNavigationRoute,
        R.drawable.ic_home,
        R.string.home,
    ),
    FAVORITE(
        favoriteNavigationRoute,
        R.drawable.ic_favorite,
        R.string.favorite
    ),
    PROFILE(
        profileNavigationRoute,
        R.drawable.ic_profile,
        R.string.profile
    )
}