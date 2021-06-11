package com.ephemerayne.psychologicaltests.di

import android.content.Context
import com.ephemerayne.presentation.di.PresentationComponentDependencies
import com.ephemerayne.psychologicaltests.MainActivity
import com.ephemerayne.psychologicaltests.di.modules.*
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppComponentDependenciesModule::class,
        FakeCategoriesRepositoryModule::class,
        NavigationActionModule::class,
        FakeTestsRepositoryModule::class,
        FakeQuestionsRepositoryModule::class,
        FakeOptionsRepositoryModule::class,
        FakeResultRepositoryModule::class,
        FakeInterpretationRepositoryModule::class
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