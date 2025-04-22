package com.mehmetpetek.basesampleapp.features.screen.home


import androidx.lifecycle.viewModelScope
import com.mehmetpetek.basesampleapp.data.remote.Memes
import com.mehmetpetek.basesampleapp.domain.usecase.GetMemesUseCase
import com.mehmetpetek.basesampleapp.features.base.BaseViewModel
import com.mehmetpetek.basesampleapp.features.base.IEffect
import com.mehmetpetek.basesampleapp.features.base.IEvent
import com.mehmetpetek.basesampleapp.features.base.IState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMemesUseCase: GetMemesUseCase
) : BaseViewModel<HomeState, HomeEvent, HomeEffect>() {

    init {
        getMemes()
    }

    override fun setInitialState() = HomeState()

    override fun handleEvents(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnDetailClick -> setEffect {
                HomeEffect.NavigateToDetail(event.memes)
            }
        }
    }

    private fun getMemes() {
        viewModelScope.launch {
            getMemesUseCase.invoke().collect {
                when (it) {
                    is GetMemesUseCase.GetMemesState.Data -> {
                        setState { copy(isLoading = false, memes = it.memes) }
                    }

                    is GetMemesUseCase.GetMemesState.EmptyData -> {
                        setState { copy(isLoading = false, memes = emptyList()) }
                    }

                    is GetMemesUseCase.GetMemesState.Error -> {
                        setState { copy(isLoading = false, memes = emptyList()) }
                    }
                }
            }
        }
    }
}


data class HomeState(
    val isLoading: Boolean = true,
    val memes: List<Memes> = emptyList()
) : IState

sealed interface HomeEffect : IEffect {
    data class ShowError(val message: String) : HomeEffect
    data class NavigateToDetail(val memes: Memes) : HomeEffect
}

sealed interface HomeEvent : IEvent {
    data class OnDetailClick(val memes: Memes) :
        HomeEvent
}