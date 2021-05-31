package com.ephemerayne.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.TestEntity
import com.ephemerayne.domain.repository.TestRepository

class FakeTestsRepository: TestRepository {

    override fun getTests(): LiveData<List<TestEntity>> {
        return MutableLiveData<List<TestEntity>>().apply {
            value = listOf(
                TestEntity(1, 1, "Fake Test 1", "description 1"),
                TestEntity(1, 2, "Fake Test 2", "description 2"),
                TestEntity(1, 3, "Fake Test 3", "description 3"),

                TestEntity(2, 4, "Fake Test 1", "description 1"),
                TestEntity(2, 5, "Fake Test 2", "description 2"),

                TestEntity(3, 6, "Fake Test 1", "description 1"),
            )
        }
    }
}