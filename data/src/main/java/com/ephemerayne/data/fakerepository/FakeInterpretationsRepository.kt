package com.ephemerayne.data.fakerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.PointsInterpretationEntity
import com.ephemerayne.domain.repository.InterpretationRepository

class FakeInterpretationsRepository : InterpretationRepository {
    val fakeResults = mutableListOf(
        PointsInterpretationEntity(1,0, 9, "Отсутствие депрессивных симптомов", "description"),
        PointsInterpretationEntity(1,10, 15, "Субдепрессия (Легкая депрессия)", "description"),
        PointsInterpretationEntity(1,16, 19, "Умеренная депрессия", "description"),
        PointsInterpretationEntity(1,20, 29, "Выраженная депрессия средней тяжести", "description"),
        PointsInterpretationEntity(1,30, 63, "Тяжелая депрессия", "description"),
    )

    override fun getInterpretation(testId: Int): LiveData<List<PointsInterpretationEntity>> {
        return MutableLiveData<List<PointsInterpretationEntity>>().apply {
            value = fakeResults
        }
    }
}