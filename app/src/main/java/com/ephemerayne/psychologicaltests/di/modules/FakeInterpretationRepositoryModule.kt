package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.fakerepository.FakeInterpretationsRepository
import com.ephemerayne.domain.repository.InterpretationRepository
import dagger.Module
import dagger.Provides

@Module
class FakeInterpretationRepositoryModule {

    @Provides
    fun provideInterpretationRepository(): InterpretationRepository =
        FakeInterpretationsRepository()
}