package com.ephemerayne.data.local.question.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.data.local.question.model.QuestionModel

class FakeQuestionsDao : QuestionsDao {
    private val fakeQuestionsLiveData = MutableLiveData<List<QuestionModel>>().apply {
        value = mutableListOf(
            QuestionModel(1, 1, "Fake Question Dao 1"),
            QuestionModel(1, 2, "Fake Question Dao 2"),
            QuestionModel(1, 3, "Fake Question Dao 3"),
        )
    }

    override fun insertQuestion(questionModel: QuestionModel) {
        fakeQuestionsLiveData.value = mutableListOf<QuestionModel>().apply {
            fakeQuestionsLiveData.value?.let { addAll(it) }
            add(questionModel)
        }
    }

    override fun getQuestions(testId: Int): LiveData<List<QuestionModel>> {
        return fakeQuestionsLiveData.apply {
            value = value?.filter { it.testId == testId }
        }
    }
}