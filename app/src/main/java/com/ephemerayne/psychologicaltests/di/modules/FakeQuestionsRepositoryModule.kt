package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.fakerepository.FakeQuestionsRepository
import com.ephemerayne.domain.repository.QuestionsRepository
import dagger.Module
import dagger.Provides

@Module
class FakeQuestionsRepositoryModule {

    @Provides
    fun provideQuestionsRepository(): QuestionsRepository = FakeQuestionsRepository()
}