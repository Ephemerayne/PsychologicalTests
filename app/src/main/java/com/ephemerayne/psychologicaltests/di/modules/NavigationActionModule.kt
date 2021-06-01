package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.api.OpenTest
import com.ephemerayne.psychologicaltests.navigation.OpenCategoryImpl
import com.ephemerayne.psychologicaltests.navigation.OpenTestImpl
import dagger.Module
import dagger.Provides

@Module
class NavigationActionModule {

    @Provides
    fun provideOpenCategory(): OpenCategory = OpenCategoryImpl()

    @Provides
    fun provideOpenTest(): OpenTest = OpenTestImpl()
}