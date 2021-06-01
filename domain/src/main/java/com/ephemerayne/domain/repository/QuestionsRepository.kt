package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.QuestionEntity

interface QuestionsRepository {

    fun getQuestions(testId: Int): LiveData<List<QuestionEntity>>
}