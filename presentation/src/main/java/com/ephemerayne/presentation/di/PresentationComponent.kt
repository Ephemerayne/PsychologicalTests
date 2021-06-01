package com.ephemerayne.presentation.di

import com.ephemerayne.domain.repository.CategoriesRepository
import com.ephemerayne.domain.repository.OptionsRepository
import com.ephemerayne.domain.repository.QuestionsRepository
import com.ephemerayne.domain.repository.TestsRepository
import com.ephemerayne.presentation.api.OpenCategory
import com.ephemerayne.presentation.api.OpenTest
import com.ephemerayne.presentation.api.OpenTestDescription
import com.ephemerayne.presentation.di.modules.ViewModelsModule
import com.ephemerayne.presentation.ui.main.MainFragment
import com.ephemerayne.presentation.ui.test.TestFragment
import com.ephemerayne.presentation.ui.testdescription.TestDescriptionFragment
import com.ephemerayne.presentation.ui.testlist.TestListFragment
import dagger.Component

interface PresentationComponentDependencies : ComponentDependencies {
    fun getCategoriesRepository(): CategoriesRepository
    fun getQuestionsRepository(): QuestionsRepository
    fun getOptionsRepository(): OptionsRepository
    fun getTestsRepository(): TestsRepository
    fun openCategory(): OpenCategory
    fun openTestDescription(): OpenTestDescription
    fun openTest(): OpenTest
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
    fun inject(testDescriptionFragment: TestDescriptionFragment)
    fun inject(testFragment: TestFragment)
}