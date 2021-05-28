package com.ephemerayne.presentation.di

import com.ephemerayne.presentation.ui.MainFragment
import dagger.Component

interface PresentationComponentDependencies : ComponentDependencies {
}

@Component(
    dependencies = [
        PresentationComponentDependencies::class
    ]
)

interface PresentationComponent {
    fun inject(mainFragment: MainFragment)
}