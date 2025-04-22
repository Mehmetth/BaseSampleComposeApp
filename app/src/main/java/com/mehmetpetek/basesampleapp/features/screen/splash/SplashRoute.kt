package com.mehmetpetek.basesampleapp.features.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mehmetpetek.basesampleapp.common.Constant
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    viewModel: SplashViewModel = hiltViewModel(), navigateToHome: () -> Unit
) {
    val viewState = viewModel.state.collectAsState().value

    LaunchedEffect(viewModel.effect) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is SplashEffect.NavigateToHome -> {
                    navigateToHome()
                }
            }
        }
    }

    SplashScreen(
        viewState, onViewEvent = viewModel::setEvent
    )
}

@Composable
private fun SplashScreen(
    viewState: SplashState, onViewEvent: (SplashEvent) -> Unit, modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        delay(Constant.SPLASH_TIME)
        onViewEvent(SplashEvent.OnGoToHome)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Splash",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    SplashScreen(viewState = SplashState(isLoading = false), onViewEvent = {})
}