package com.mehmetpetek.basesampleapp.data

import javax.inject.Inject

class BaseSampleAppDataSource @Inject constructor(
    private val baseSampleAppService: BaseSampleAppService
) {
    suspend fun getMemes() = baseSampleAppService.getMemes()
}