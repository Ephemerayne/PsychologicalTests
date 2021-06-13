package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.fakerepository.FakeCategoriesRepository
import com.ephemerayne.domain.repository.CategoriesRepository
import dagger.Module
import dagger.Provides

@Module
class FakeCategoriesRepositoryModule {

    @Provides
    fun provideCategoriesRepository(): CategoriesRepository = FakeCategoriesRepository()
}