package com.ephemerayne.presentation.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.OptionEntity
import com.ephemerayne.domain.entity.QuestionEntity
import com.ephemerayne.domain.repository.OptionsRepository
import com.ephemerayne.domain.repository.QuestionsRepository
import javax.inject.Inject

class TestViewModel @Inject constructor(
    private val questionsRepository: QuestionsRepository,
    private val optionsRepository: OptionsRepository,
) : ViewModel() {

    var questions: List<QuestionEntity> = listOf()
    private var questionIndex = 0

    fun getQuestions(testId: Int): LiveData<List<QuestionEntity>> =
        questionsRepository.getQuestions(testId)

    fun getOptions(questionId: Int): LiveData<List<OptionEntity>> =
        optionsRepository.getOptions(questionId)

    fun getNextQuestion(): QuestionEntity? {
        if (questionIndex <= questions.size - 2) {
            questionIndex++
            return questions[questionIndex]
        }
        return null
    }
}