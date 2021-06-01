package com.ephemerayne.presentation.ui.testdescription

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.domain.repository.TestRepository
import javax.inject.Inject

class TestDescriptionViewModel @Inject constructor(
    private val repository: TestRepository
): ViewModel() {

    fun getTests(): LiveData<List<TestEntity>> = repository.getTests()

    fun getTest(id: Int) = repository.getTest(id)
}