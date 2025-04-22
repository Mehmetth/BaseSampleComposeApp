package com.mehmetpetek.basesampleapp.domain.repository

import com.mehmetpetek.basesampleapp.data.remote.MemesResponse
import com.mehmetpetek.basesampleapp.data.remote.Resource
import kotlinx.coroutines.flow.Flow

interface BaseSampleAppRepository {
    fun getMemes(): Flow<Resource<MemesResponse>>
}