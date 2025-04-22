package com.mehmetpetek.basesampleapp.app.di

import com.mehmetpetek.basesampleapp.data.BaseSampleAppDataSource
import com.mehmetpetek.basesampleapp.data.BaseSampleAppService
import com.mehmetpetek.basesampleapp.data.repository.BaseSampleAppRepositoryImpl
import com.mehmetpetek.basesampleapp.domain.repository.BaseSampleAppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBaseSampleAppDataSource(
        baseSampleAppService: BaseSampleAppService,
    ): BaseSampleAppDataSource = BaseSampleAppDataSource(baseSampleAppService)

    @Provides
    @Singleton
    fun provideBaseSampleAppRepository(
        baseSampleAppDataSource: BaseSampleAppDataSource,
    ): BaseSampleAppRepository = BaseSampleAppRepositoryImpl(baseSampleAppDataSource)

}