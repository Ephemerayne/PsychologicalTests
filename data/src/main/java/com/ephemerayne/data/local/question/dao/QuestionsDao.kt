package com.ephemerayne.data.local.question.dao

import androidx.lifecycle.LiveData
import com.ephemerayne.data.local.question.model.QuestionModel

interface QuestionsDao {

    fun insertQuestion(questionModel: QuestionModel)

    fun getQuestions(testId: Int): LiveData<List<QuestionModel>>
}