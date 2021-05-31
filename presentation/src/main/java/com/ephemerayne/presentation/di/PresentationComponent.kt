package com.ephemerayne.presentation.di

import com.ephemerayne.domain.repository.CategoryRepository
import com.ephemerayne.domain.repository.TestRepository
import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.di.modules.ViewModelsModule
import com.ephemerayne.presentation.ui.main.MainFragment
import com.ephemerayne.presentation.ui.testlist.TestListFragment
import dagger.Component

interface PresentationComponentDependencies : ComponentDependencies {
    fun getCategoriesRepository(): CategoryRepository
    fun getTestsRepository(): TestRepository
    fun openCategory(): OpenCategory
}

@Component(
    dependencies = [
        PresentationComponentDependencies::class
    ],
    modules = [
        ViewModelsModule::class
    ]
)

interface PresentationComponent {
    fun inject(mainFragment: MainFragment)
    fun inject(testListFragment: TestListFragment)
}