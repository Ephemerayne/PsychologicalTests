package com.ephemerayne.data.local.question.repositoryimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.question.dao.QuestionsDao
import com.ephemerayne.data.local.question.modelsToEntities
import com.ephemerayne.data.local.question.responseToModel
import com.ephemerayne.data.remote.Api
import com.ephemerayne.data.response.QuestionResponse
import com.ephemerayne.domain.entity.QuestionEntity
import com.ephemerayne.domain.repository.QuestionsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class QuestionsRepositoryImpl(
    private val questionsDao: QuestionsDao,
    private val api: Api
) : QuestionsRepository {

    override fun getQuestions(testId: Int): LiveData<List<QuestionEntity>> {
        api.getQuestions(testId)
            .subscribeOn(Schedulers.io())
            //TODO change to schedulers.io()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<QuestionResponse>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(testResponses: List<QuestionResponse>?) {
                    testResponses?.let {
                        for (question in it) {
                            questionsDao.insertQuestion(question.responseToModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }

            })
        return questionsDao.getQuestions(testId).map { it.modelsToEntities() }
    }
}