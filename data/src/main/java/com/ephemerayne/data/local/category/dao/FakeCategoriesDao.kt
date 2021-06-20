package com.ephemerayne.data.local.category.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.data.local.category.model.CategoryModel

class FakeCategoriesDao : CategoriesDao {
    private val fakeCategoriesLiveData = MutableLiveData<List<CategoryModel>>().apply {
        value = mutableListOf(
            CategoryModel(1, "Fake Category DAO 1"),
            CategoryModel(2, "Fake Category DAO 2"),
            CategoryModel(3, "Fake Category DAO 3"),
            CategoryModel(4, "Fake Category DAO 4"),
        )
    }

    override fun insertCategory(categoryModel: CategoryModel) {
        fakeCategoriesLiveData.value = mutableListOf<CategoryModel>().apply {
            fakeCategoriesLiveData.value?.let { addAll(it) }
            add(categoryModel)
        }
    }

    override fun getCategories(): LiveData<List<CategoryModel>> {
        return fakeCategoriesLiveData
    }
}
