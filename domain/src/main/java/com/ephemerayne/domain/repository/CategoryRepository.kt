package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.CategoryEntity

interface CategoryRepository {

    fun getCategories(): LiveData<List<CategoryEntity>>
}