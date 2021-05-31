package com.ephemerayne.presentation.ui.testlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.domain.repository.TestRepository
import javax.inject.Inject

class TestListViewModel @Inject constructor(
    private val repository: TestRepository
): ViewModel() {

    fun getTests(): LiveData<List<TestEntity>> = repository.getTests()

}