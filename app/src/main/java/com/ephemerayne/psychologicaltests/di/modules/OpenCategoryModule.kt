package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.psychologicaltests.navigation.OpenCategoryImpl
import dagger.Module
import dagger.Provides

@Module
class OpenCategoryModule {

    @Provides
    fun provideOpenCategory(): OpenCategory = OpenCategoryImpl()
}