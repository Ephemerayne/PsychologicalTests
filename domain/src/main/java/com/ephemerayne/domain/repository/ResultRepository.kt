package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.ResultEntity

interface ResultRepository {

    fun insert(resultEntity: ResultEntity)

    fun getResult(testId: Int): LiveData<List<ResultEntity>>

    fun deleteStatistics(testId: Int)
}