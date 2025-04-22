package com.mehmetpetek.basesampleapp.features.screen.favorite

import com.mehmetpetek.basesampleapp.features.base.BaseViewModel
import com.mehmetpetek.basesampleapp.features.base.IEffect
import com.mehmetpetek.basesampleapp.features.base.IEvent
import com.mehmetpetek.basesampleapp.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
) : BaseViewModel<FavoriteState, FavoriteEvent, FavoriteEffect>() {

    override fun setInitialState() = FavoriteState()

    override fun handleEvents(event: FavoriteEvent) {}
}

data class FavoriteState(
    val isLoading: Boolean = false
) : IState

sealed interface FavoriteEffect : IEffect

sealed interface FavoriteEvent : IEvent