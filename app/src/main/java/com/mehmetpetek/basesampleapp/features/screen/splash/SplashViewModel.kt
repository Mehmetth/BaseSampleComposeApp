package com.mehmetpetek.basesampleapp.features.screen.splash

import com.mehmetpetek.basesampleapp.features.base.BaseViewModel
import com.mehmetpetek.basesampleapp.features.base.IEffect
import com.mehmetpetek.basesampleapp.features.base.IEvent
import com.mehmetpetek.basesampleapp.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
) : BaseViewModel<SplashState, SplashEvent, SplashEffect>() {

    override fun setInitialState() = SplashState()

    override fun handleEvents(event: SplashEvent) {
        when (event) {
            is SplashEvent.OnGoToHome -> {
                setEffect { SplashEffect.NavigateToHome }
            }
        }
    }
}

data class SplashState(
    val isLoading: Boolean = false,
    val goToHome: Boolean = false
) : IState

sealed interface SplashEffect : IEffect {
    object NavigateToHome : SplashEffect
}

sealed interface SplashEvent : IEvent {
    object OnGoToHome : SplashEvent
}