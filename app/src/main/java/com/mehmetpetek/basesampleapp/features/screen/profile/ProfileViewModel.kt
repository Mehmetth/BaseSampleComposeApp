package com.mehmetpetek.basesampleapp.features.screen.profile

import com.mehmetpetek.basesampleapp.features.base.BaseViewModel
import com.mehmetpetek.basesampleapp.features.base.IEffect
import com.mehmetpetek.basesampleapp.features.base.IEvent
import com.mehmetpetek.basesampleapp.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
) : BaseViewModel<ProfileState, ProfileEvent, ProfileEffect>() {

    override fun setInitialState() = ProfileState()

    override fun handleEvents(event: ProfileEvent) {}
}

data class ProfileState(
    val isLoading: Boolean = false
) : IState

sealed interface ProfileEffect : IEffect

sealed interface ProfileEvent : IEvent