package com.mehmetpetek.basesampleapp.data

import com.mehmetpetek.basesampleapp.data.remote.MemesResponse
import retrofit2.Response
import retrofit2.http.GET

interface BaseSampleAppService {
    @GET("get_memes")
    suspend fun getMemes(): Response<MemesResponse>
}