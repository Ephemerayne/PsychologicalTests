package com.ephemerayne.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.data.model.CategoryModel

class FakeCategoriesDao : CategoriesDao {

    override fun insertCategory(categoryModel: CategoryModel) {
    }

    override fun getCategories(): LiveData<List<CategoryModel>> {
        return MutableLiveData<List<CategoryModel>>().apply {
            value = mutableListOf(
                CategoryModel(1, "Fake Category DAO 1"),
                CategoryModel(2, "Fake Category DAO 2"),
                CategoryModel(3, "Fake Category DAO 3"),
                CategoryModel(4, "Fake Category DAO 4"),
            )
        }
    }
}