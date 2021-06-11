package com.ephemerayne.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.domain.repository.ResultRepository
import org.threeten.bp.LocalDateTime


class FakeResultRepository : ResultRepository {

    override fun insert(resultEntity: ResultEntity) {
    }

    override fun getResult(testId: Int): LiveData<List<ResultEntity>> {
        return MutableLiveData<List<ResultEntity>>().apply {
            value = mutableListOf(
                ResultEntity(0, 1, LocalDateTime.now(), 8),
                ResultEntity(1, 1, LocalDateTime.now(), 14),
                ResultEntity(2, 1, LocalDateTime.now(), 17),
                ResultEntity(30, 1, LocalDateTime.now(), 25),
                ResultEntity(9, 1, LocalDateTime.now(), 40),
                ResultEntity(5, 1, LocalDateTime.now(), 2),
                ResultEntity(6, 1, LocalDateTime.now(), 50),
            )

        }
    }

    override fun deleteStatistics(testId: Int) {
    }
}