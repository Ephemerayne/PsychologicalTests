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

    var questions: List<QuestionEntity>? = listOf()

    fun getQuestions(testId: Int): LiveData<List<QuestionEntity>> =
        questionsRepository.getQuestions(testId)

    fun getOptions(questionId: Int): LiveData<List<OptionEntity>> =
        optionsRepository.getOptions(questionId)
}