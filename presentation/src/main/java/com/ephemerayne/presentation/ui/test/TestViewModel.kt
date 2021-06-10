package com.ephemerayne.presentation.ui.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    var questionIndex = 0
    var questionsToAnswers = HashMap<QuestionEntity, OptionEntity>()
    private val isLastQuestionMLD: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = false
    }
    private val currentQuestionMLD: MutableLiveData<QuestionEntity> =
        MutableLiveData<QuestionEntity>()
    val currentQuestionLiveData: LiveData<QuestionEntity> = currentQuestionMLD

    val isLastQuestionLiveData: LiveData<Boolean> = isLastQuestionMLD

    fun getQuestions(testId: Int): LiveData<List<QuestionEntity>> =
        questionsRepository.getQuestions(testId)

    fun getOptions(questionId: Int): LiveData<List<OptionEntity>> =
        optionsRepository.getOptions(questionId)

    fun getNextQuestion(): QuestionEntity {
        return if (questionIndex <= questions.size - 2) {
            questionIndex++
            questions[questionIndex]
        } else {
            questions.last()
        }
    }

    fun getPreviousQuestion(): QuestionEntity {
        return if (questionIndex > 0) {
            questionIndex--
            questions[questionIndex]
        } else {
            questions.first()
        }
    }

    fun setAnswer(optionEntity: OptionEntity) {
        questionsToAnswers[questions[questionIndex]] = optionEntity
    }

    fun checkIsLastQuestion() {
        isLastQuestionMLD.value = questionIndex == questions.lastIndex
    }

    fun setNextQuestion() {
        currentQuestionMLD.value = questions[questionIndex]
    }
}