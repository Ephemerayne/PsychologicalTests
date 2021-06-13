package com.ephemerayne.data.fakerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.domain.repository.CategoriesRepository

class FakeCategoriesRepository: CategoriesRepository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
       return MutableLiveData<List<CategoryEntity>>().apply {
           value = listOf(
               CategoryEntity(1, "Fake Repo Category 1"),
               CategoryEntity(2, "Fake Repo Category 2"),
               CategoryEntity(3, "Fake Repo Category 3"),
           )
       }
    }
}