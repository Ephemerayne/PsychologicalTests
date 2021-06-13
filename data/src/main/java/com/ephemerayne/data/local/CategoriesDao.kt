package com.ephemerayne.data.local

import androidx.lifecycle.LiveData
import com.ephemerayne.data.model.CategoryModel

interface CategoriesDao {

    fun insertCategory(categoryModel: CategoryModel)

    fun getCategories(): LiveData<List<CategoryModel>>
}