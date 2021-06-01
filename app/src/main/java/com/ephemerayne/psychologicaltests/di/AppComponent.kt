package com.ephemerayne.psychologicaltests.di

import android.content.Context
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.psychologicaltests.MainActivity
import com.ephemerayne.psychologicaltests.di.modules.FakeCategoriesRepositoryModule
import com.ephemerayne.psychologicaltests.di.modules.FakeTestsRepositoryModule
import com.ephemerayne.psychologicaltests.di.modules.NavigationActionModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppComponentDependenciesModule::class,
        FakeCategoriesRepositoryModule::class,
        NavigationActionModule::class,
        FakeTestsRepositoryModule::class,
    ]
)
interface AppComponent : PresentationComponentDependencies {
    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): AppComponent
    }
}