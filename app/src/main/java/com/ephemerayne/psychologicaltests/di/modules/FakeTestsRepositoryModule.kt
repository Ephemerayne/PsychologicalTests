package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.fakerepository.FakeTestsRepository
import com.ephemerayne.domain.repository.TestsRepository
import dagger.Module
import dagger.Provides

@Module
class FakeTestsRepositoryModule {

    @Provides
    fun provideTestRepository(): TestsRepository = FakeTestsRepository()
}