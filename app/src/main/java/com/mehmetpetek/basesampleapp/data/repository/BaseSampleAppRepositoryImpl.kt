package com.mehmetpetek.basesampleapp.data.repository

import com.mehmetpetek.basesampleapp.data.BaseSampleAppDataSource
import com.mehmetpetek.basesampleapp.data.remote.MemesResponse
import com.mehmetpetek.basesampleapp.data.remote.Resource
import com.mehmetpetek.basesampleapp.domain.repository.BaseSampleAppRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class BaseSampleAppRepositoryImpl @Inject constructor(
    private val baseSampleAppDataSource: BaseSampleAppDataSource
) : BaseSampleAppRepository {

    override fun getMemes(): Flow<Resource<MemesResponse>> =
        callbackFlow {
            val response = baseSampleAppDataSource.getMemes()
            if (response.isSuccessful) {
                response.body()?.let {
                    trySend(Resource.Success(it))
                } ?: kotlin.run {
                    trySend(Resource.Fail(null))
                }
            } else {
                trySend(Resource.Error(null))
            }
            awaitClose { cancel() }
        }
}