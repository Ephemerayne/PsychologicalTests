package com.ephemerayne.data.local.test.repositoryimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.test.dao.TestsDao
import com.ephemerayne.data.local.test.modelToEntity
import com.ephemerayne.data.local.test.modelsToEntities
import com.ephemerayne.data.local.test.responseToModel
import com.ephemerayne.data.remote.Api
import com.ephemerayne.data.response.TestResponse
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.domain.repository.TestsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TestsRepositoryImpl(
    private val testsDao: TestsDao,
    private val api: Api
) : TestsRepository {

    override fun getTests(): LiveData<List<TestEntity>> {
        api.getTests()
            .subscribeOn(Schedulers.io())
            //TODO change to schedulers.io()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<TestResponse>> {
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(testResponses: List<TestResponse>?) {
                    testResponses?.let {
                        for (test in it) {
                            testsDao.insertTest(test.responseToModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }

            })
        return testsDao.getTests().map { it.modelsToEntities() }
    }

    override fun getTest(id: Int): LiveData<TestEntity> {
    api.getTest(id)
        .subscribeOn(Schedulers.io())
        //TODO change to schedulers.io()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object : Observer<TestResponse> {
            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(testResponses: TestResponse?) {
                testResponses?.let {
                    testsDao.insertTest(it.responseToModel())
                }
            }

            override fun onError(e: Throwable?) {
                println(e)
            }

            override fun onComplete() {
            }

        })
        return testsDao.getTest(id).map { it.modelToEntity() }
    }

}