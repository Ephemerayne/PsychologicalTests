package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.local.test.dao.FakeTestsDao
import com.ephemerayne.data.local.test.dao.TestsDao
import com.ephemerayne.data.local.test.repositoryimpl.TestsRepositoryImpl
import com.ephemerayne.data.remote.Api
import com.ephemerayne.domain.repository.TestsRepository
import dagger.Module
import dagger.Provides

@Module
class TestsRepositoryModule {

    @Provides
    fun provideTestsRepository(testsDao: TestsDao, api: Api): TestsRepository =
        TestsRepositoryImpl(testsDao, api)

    @Provides
    fun provideTestsDao(): TestsDao = FakeTestsDao()
}
