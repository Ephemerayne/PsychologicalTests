package com.ephemerayne.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.CategoryEntity
import com.ephemerayne.domain.repository.CategoriesRepository
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor(
    private val repository: CategoriesRepository
) : ViewModel() {

    fun getCategories(): LiveData<List<CategoryEntity>> = repository.getCategories()
}