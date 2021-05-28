package com.ephemerayne.presentation.di

import com.ephemerayne.presentation.ui.BaseFragment

object PresentationComponentHolder {
    private var component: PresentationComponent? = null

    fun getComponent(fragment: BaseFragment): PresentationComponent {
        return component
            ?: DaggerPresentationComponent.builder()
                .presentationComponentDependencies(fragment.getDependencies())
                .build()
                .apply { component = this }
    }
}