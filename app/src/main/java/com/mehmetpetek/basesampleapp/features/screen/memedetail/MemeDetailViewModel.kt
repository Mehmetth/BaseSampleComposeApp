package com.mehmetpetek.basesampleapp.features.screen.memeMemeDetail

import androidx.lifecycle.SavedStateHandle
import com.mehmetpetek.basesampleapp.common.helper.getDataFromJsonString
import com.mehmetpetek.basesampleapp.data.remote.Memes
import com.mehmetpetek.basesampleapp.features.base.BaseViewModel
import com.mehmetpetek.basesampleapp.features.base.IEffect
import com.mehmetpetek.basesampleapp.features.base.IEvent
import com.mehmetpetek.basesampleapp.features.base.IState
import com.mehmetpetek.basesampleapp.features.navigation.MemeDetailArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemeDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) :
    BaseViewModel<MemeDetailState, MemeDetailEvent, MemeDetailEffect>() {

    private val args = MemeDetailArgs(savedStateHandle)

    init {
        setState { copy(meme = getDataFromJsonString<Memes>(args.memeDetail)) }
    }

    override fun setInitialState() = MemeDetailState(isLoading = false)

    override fun handleEvents(event: MemeDetailEvent) {
        when (event) {
            else -> {}
        }
    }
}


data class MemeDetailState(
    val isLoading: Boolean = false,
    val meme: Memes? = null
) : IState

sealed interface MemeDetailEffect : IEffect {
    data class ShowError(val message: String) : MemeDetailEffect
}

sealed interface MemeDetailEvent : IEvent