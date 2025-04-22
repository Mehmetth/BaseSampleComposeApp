package com.mehmetpetek.basesampleapp.features.screen.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FavoriteRoute(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
        }
    }

    FavoriteScreen(
        viewState, onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun FavoriteScreen(
    viewState: FavoriteState, onViewEvent: (FavoriteEvent) -> Unit, modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Favorite"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFavoriteScreen() {
    FavoriteScreen(viewState = FavoriteState(isLoading = false), onViewEvent = {})
}