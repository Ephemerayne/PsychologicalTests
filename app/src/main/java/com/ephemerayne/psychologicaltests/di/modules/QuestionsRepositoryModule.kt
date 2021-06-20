package com.ephemerayne.psychologicaltests.di.modules

import com.ephemerayne.data.local.question.dao.FakeQuestionsDao
import com.ephemerayne.data.local.question.dao.QuestionsDao
import com.ephemerayne.data.local.question.repositoryimpl.QuestionsRepositoryImpl
import com.ephemerayne.data.remote.Api
import com.ephemerayne.domain.repository.QuestionsRepository
import dagger.Module
import dagger.Provides

@Module
class QuestionsRepositoryModule {

    @Provides
    fun provideQuestionsRepository(questionsDao: QuestionsDao, api: Api): QuestionsRepository =
        QuestionsRepositoryImpl(questionsDao, api)

    @Provides
    fun provideQuestionsDao(): QuestionsDao = FakeQuestionsDao()
}