package com.mehmetpetek.basesampleapp.features.navigation

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.composable
import com.mehmetpetek.basesampleapp.features.screen.memeMemeDetail.MemeDetailScreenRoute

const val memeDetailNavigationRoute = "meme_detail_route"
const val memeDetailArg = "meme_detail_arg"

internal class MemeDetailArgs(val memeDetail: String) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(memeDetail = checkNotNull(Uri.decode(savedStateHandle[memeDetailArg])))
}

fun NavController.navigateToMemeDetail(memeDetail: String, navOptions: NavOptions? = null) {
    val memeDetailArg = Uri.encode(memeDetail)
    this.navigate(memeDetailNavigationRoute.plus("/$memeDetailArg"), navOptions)
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.memeDetailScreen() {
    composable(
        route = memeDetailNavigationRoute.plus("/{$memeDetailArg}"),
        arguments = listOf(
            navArgument(memeDetailArg) { type = NavType.StringType }
        )) {
        MemeDetailScreenRoute()
    }
}