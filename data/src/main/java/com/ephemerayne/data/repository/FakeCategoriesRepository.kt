package com.ephemerayne.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.domain.repository.CategoryRepository

class FakeCategoriesRepository: CategoryRepository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
       return MutableLiveData<List<CategoryEntity>>().apply {
           value = listOf(
               CategoryEntity(1, "Fake Repo Category 1"),
               CategoryEntity(3, "Fake Repo Category 2"),
               CategoryEntity(5, "Fake Repo Category 3"),
           )
       }
    }
}