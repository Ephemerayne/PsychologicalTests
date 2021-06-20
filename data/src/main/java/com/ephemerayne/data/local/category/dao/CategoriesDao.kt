package com.ephemerayne.data.local.category.dao

import androidx.lifecycle.LiveData
import com.ephemerayne.data.local.category.model.CategoryModel

interface CategoriesDao {

    fun insertCategory(categoryModel: CategoryModel)

    fun getCategories(): LiveData<List<CategoryModel>>
}