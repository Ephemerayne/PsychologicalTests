package com.ephemerayne.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ephemerayne.presentation.di.PresentationComponent
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.presentation.di.PresentationComponentHolder

abstract class BaseFragment(layoutId: Int): Fragment(layoutId) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PresentationComponentHolder.getComponent(this)
            .also { injectDependencies(it) }
    }

   abstract fun getDependencies(): PresentationComponentDependencies

   abstract fun injectDependencies(component: PresentationComponent)
}