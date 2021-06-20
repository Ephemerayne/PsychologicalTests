package com.ephemerayne.data.local.test.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.data.local.test.model.TestModel

class FakeTestsDao : TestsDao {
    private val fakeTestsLiveData = MediatorLiveData<List<TestModel>>().apply {
        value = mutableListOf(
            TestModel(1, 1, "Fake Test DAO 1", "desc"),
            TestModel(1, 2, "Fake Test DAO 2", "desc"),
            TestModel(1, 3, "Fake Test DAO 3", "desc"),
        )
    }

    override fun insertTest(testModel: TestModel) {
        fakeTestsLiveData.value = mutableListOf<TestModel>().apply {
            fakeTestsLiveData.value?.let { addAll(it) }
            add(testModel)
        }
    }

    override fun getTests(): LiveData<List<TestModel>> {
        return fakeTestsLiveData
    }

    override fun getTest(id: Int): LiveData<TestModel> {
        return MutableLiveData<TestModel>().apply {
            value = TestModel(1, 11, "FAKE TEST DAO 1", "desc")
        }
    }
}