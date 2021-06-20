package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.local.option.dao.FakeOptionsDao
import com.ephemerayne.data.local.option.dao.OptionsDao
import com.ephemerayne.data.local.option.repositoryimpl.OptionsRepositoryImpl
import com.ephemerayne.data.remote.Api
import com.ephemerayne.domain.repository.OptionsRepository
import dagger.Module
import dagger.Provides

@Module
class OptionsRepositoryModule {

    @Provides
    fun provideOptionsRepository(optionsDao: OptionsDao, api: Api): OptionsRepository =
        OptionsRepositoryImpl(optionsDao, api)

    @Provides
    fun provideOptionsDap(): OptionsDao = FakeOptionsDao()
}