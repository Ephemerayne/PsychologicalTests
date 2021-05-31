package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.repository.FakeTestsRepository
import com.ephemerayne.domain.repository.TestRepository
import dagger.Module
import dagger.Provides

@Module
class FakeTestsRepositoryModule {

    @Provides
    fun provideTestRepository(): TestRepository = FakeTestsRepository()
}