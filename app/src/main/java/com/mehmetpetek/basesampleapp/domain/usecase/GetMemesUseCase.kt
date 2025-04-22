package com.mehmetpetek.basesampleapp.domain.usecase

import com.mehmetpetek.basesampleapp.data.remote.Memes
import com.mehmetpetek.basesampleapp.data.remote.Resource
import com.mehmetpetek.basesampleapp.domain.repository.BaseSampleAppRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class GetMemesUseCase @Inject constructor(
    private val baseSampleAppRepository: BaseSampleAppRepository
) {
    operator fun invoke(): Flow<GetMemesState> = callbackFlow {
        baseSampleAppRepository.getMemes().collect { result ->
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        if (it.data.memes.isNotEmpty()) {
                            trySend(
                                GetMemesState.Data(it.data.memes)
                            )
                        } else {
                            trySend(
                                GetMemesState.EmptyData
                            )
                        }
                    } ?: run {
                        trySend(
                            GetMemesState.EmptyData
                        )
                    }
                }

                is Resource.Error,
                is Resource.Fail -> {
                    trySend(GetMemesState.Error(result.message))
                }
            }
        }
        awaitClose { cancel() }
    }


    sealed interface GetMemesState {
        data class Data(val memes: List<Memes>) : GetMemesState
        data class Error(val throwable: Throwable?) : GetMemesState
        object EmptyData : GetMemesState
    }
}