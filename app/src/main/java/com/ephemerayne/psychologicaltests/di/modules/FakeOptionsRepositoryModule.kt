package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.repository.FakeOptionsRepository
import com.ephemerayne.domain.repository.OptionsRepository
import dagger.Module
import dagger.Provides

@Module
class FakeOptionsRepositoryModule {

    @Provides
    fun provideOptionRepository(): OptionsRepository = FakeOptionsRepository()
}