package com.ephemerayne.data.local.test.dao

import androidx.lifecycle.LiveData
import com.ephemerayne.data.local.test.model.TestModel

interface TestsDao {

    fun insertTest(testModel: TestModel)

    fun getTests(): LiveData<List<TestModel>>

    fun getTest(id: Int): LiveData<TestModel>
}