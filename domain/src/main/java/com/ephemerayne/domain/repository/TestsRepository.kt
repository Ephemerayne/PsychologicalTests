package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.TestEntity

interface TestsRepository {

    fun getTests(): LiveData<List<TestEntity>>

    fun getTest(id: Int): LiveData<TestEntity>
}