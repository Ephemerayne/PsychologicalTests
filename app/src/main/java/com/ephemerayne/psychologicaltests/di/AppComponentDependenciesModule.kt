package com.ephemerayne.psychologicaltests.di

import com.ephemerayne.presentation.di.ComponentDependencies
import com.ephemerayne.presentation.di.ComponentDependenciesKey
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface AppComponentDependenciesModule {
    @Binds
    @IntoMap
    @ComponentDependenciesKey(PresentationComponentDependencies::class)
    fun bindPresentationComponentDependencies(component: AppComponent): ComponentDependencies
}