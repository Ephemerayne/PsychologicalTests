package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.local.category.dao.CategoriesDao
import com.ephemerayne.data.local.category.dao.FakeCategoriesDao
import com.ephemerayne.data.local.category.repositoryimpl.CategoriesRepositoryImpl
import com.ephemerayne.data.remote.Api
import com.ephemerayne.data.remote.FakeApi
import com.ephemerayne.domain.repository.CategoriesRepository
import dagger.Module
import dagger.Provides

@Module
class CategoriesRepositoryModule {

    @Provides
    fun provideCategoriesRepository(categoriesDao: CategoriesDao, api: Api): CategoriesRepository =
        CategoriesRepositoryImpl(categoriesDao, api)

    @Provides
    fun provideCategoriesApi(): Api = FakeApi()

    @Provides
    fun provideCategoriesDao(): CategoriesDao = FakeCategoriesDao()
}