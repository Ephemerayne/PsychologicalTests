package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.fakerepository.FakeResultRepository
import com.ephemerayne.domain.repository.ResultRepository
import dagger.Module
import dagger.Provides

@Module
class FakeResultRepositoryModule {

    @Provides
    fun provideRepository(): ResultRepository = FakeResultRepository()
}