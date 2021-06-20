package com.ephemerayne.data.local.category.repositoryimpl

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.category.dao.CategoriesDao
import com.ephemerayne.data.local.category.modelsToEntities
import com.ephemerayne.data.local.category.responseToModel
import com.ephemerayne.data.remote.Api
import com.ephemerayne.data.response.CategoryResponse
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.domain.repository.CategoriesRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CategoriesRepositoryImpl(
    private val categoriesDao: CategoriesDao,
    private val api: Api
) : CategoriesRepository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        api.getCategories()
            .subscribeOn(Schedulers.io())
            //TODO change to schedulers.io()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<List<CategoryResponse>> {

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(categoryResponses: List<CategoryResponse>?) {
                    categoryResponses?.let {
                        for (category in it) {
                            categoriesDao.insertCategory(category.responseToModel())
                        }
                    }
                }

                override fun onError(e: Throwable?) {
                    println(e)
                }

                override fun onComplete() {

                }

            })

        return categoriesDao.getCategories().map { it.modelsToEntities() }
    }
}