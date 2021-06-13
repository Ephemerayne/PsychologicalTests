package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.local.CategoriesDao
import com.ephemerayne.data.local.FakeCategoriesDao
import com.ephemerayne.data.repository.CategoriesRepositoryImpl
import com.ephemerayne.domain.repository.CategoriesRepository
import dagger.Module
import dagger.Provides

@Module
class CategoriesRepositoryModule {

    @Provides
    fun provideCategoriesRepository(categoriesDao: CategoriesDao): CategoriesRepository =
        CategoriesRepositoryImpl(categoriesDao)


    @Provides
    fun provideCategoriesDao(): CategoriesDao = FakeCategoriesDao()
}