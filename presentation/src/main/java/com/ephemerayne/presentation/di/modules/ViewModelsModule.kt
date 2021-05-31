package com.ephemerayne.presentation.di.modules

import androidx.lifecycle.ViewModel
import com.ephemerayne.presentation.di.ViewModelKey
import com.ephemerayne.presentation.ui.main.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun mainFragmentViewModel(viewModel: MainFragmentViewModel): ViewModel
}