package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.repository.FakeCategoriesRepository
import com.ephemerayne.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides

@Module
class FakeCategoriesRepositoryModule {

    @Provides
    fun provideCategoriesRepository(): CategoryRepository = FakeCategoriesRepository()
}