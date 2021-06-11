package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.api.OpenResult
import com.ephemerayne.presentation.api.OpenTest
import com.ephemerayne.presentation.api.OpenTestDescription
import com.ephemerayne.psychologicaltests.navigation.OpenCategoryImpl
import com.ephemerayne.psychologicaltests.navigation.OpenResultImpl
import com.ephemerayne.psychologicaltests.navigation.OpenTestDescriptionImpl
import com.ephemerayne.psychologicaltests.navigation.OpenTestImpl
import dagger.Module
import dagger.Provides

@Module
class NavigationActionModule {

    @Provides
    fun provideOpenCategory(): OpenCategory = OpenCategoryImpl()

    @Provides
    fun provideOpenTestDescription(): OpenTestDescription = OpenTestDescriptionImpl()

    @Provides
    fun provideOpenTest(): OpenTest = OpenTestImpl()

    @Provides
    fun provideOpenResult(): OpenResult = OpenResultImpl()
}