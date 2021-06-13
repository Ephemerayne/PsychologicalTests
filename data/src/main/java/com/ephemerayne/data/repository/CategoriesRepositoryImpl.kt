package com.ephemerayne.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.CategoriesDao
import com.ephemerayne.data.toEntityList
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.domain.repository.CategoriesRepository

class CategoriesRepositoryImpl(
    private val categoriesDao: CategoriesDao
) : CategoriesRepository {

    override fun getCategories(): LiveData<List<CategoryEntity>> {
        return categoriesDao.getCategories().map { it.toEntityList() }
    }
}