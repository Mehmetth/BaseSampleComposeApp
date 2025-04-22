package com.mehmetpetek.basesampleapp.features.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mehmetpetek.basesampleapp.data.remote.Memes
import com.mehmetpetek.basesampleapp.features.component.CardItem
import com.mehmetpetek.basesampleapp.features.component.LoadingContent

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToMemeDetail: (Memes) -> Unit
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToDetail -> {
                    navigateToMemeDetail(effect.memes)
                }

                is HomeEffect.ShowError -> Unit
            }
        }
    }

    HomeScreen(
        viewState,
        onViewEvent = viewModel::setEvent
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeScreen(
    viewState: HomeState,
    onViewEvent: (HomeEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    LoadingContent(isLoading = viewState.isLoading, modifier = modifier.fillMaxSize()) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier,
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 16.dp,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(viewState.memes) {
                CardItem(
                    memes = it,
                    detailClick = {
                        onViewEvent(HomeEvent.OnDetailClick(it))
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(viewState = HomeState(isLoading = false), onViewEvent = {})
}