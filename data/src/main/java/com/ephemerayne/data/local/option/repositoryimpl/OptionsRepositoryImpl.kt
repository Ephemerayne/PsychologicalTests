package com.ephemerayne.data.local.option.repositoryimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.option.dao.OptionsDao
import com.ephemerayne.data.local.option.modelsToEntities
import com.ephemerayne.data.local.option.responseToModel
import com.ephemerayne.data.remote.Api
import com.ephemerayne.data.response.OptionResponse
import com.ephemerayne.domain.entity.OptionEntity
import com.ephemerayne.domain.repository.OptionsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class OptionsRepositoryImpl(
    private val optionsDao: OptionsDao,
    private val api: Api
) : OptionsRepository {

    override fun getOptions(questionId: Int): LiveData<List<OptionEntity>> {
        api.getOptions(questionId)
            .subscribeOn(Schedulers.io())
            //TODO change to schedulers.io()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<OptionResponse>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(optionResponses: List<OptionResponse>?) {
                    optionResponses?.let {
                        for (option in it) {
                            optionsDao.insertOption(option.responseToModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {
                }

            })
        return optionsDao.getOptions(questionId).map { it.modelsToEntities() }
    }
}