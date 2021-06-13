package com.ephemerayne.data.fakerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.QuestionEntity
import com.ephemerayne.domain.repository.QuestionsRepository

class FakeQuestionsRepository: QuestionsRepository {

    override fun getQuestions(testId: Int): LiveData<List<QuestionEntity>> {
        return MutableLiveData<List<QuestionEntity>>().apply {
            value = listOf(
                QuestionEntity(1, 1, "Question 1"),
                QuestionEntity(1, 2, "Question 2"),
                QuestionEntity(1, 3, "Question 3"),
            )
        }
    }
}