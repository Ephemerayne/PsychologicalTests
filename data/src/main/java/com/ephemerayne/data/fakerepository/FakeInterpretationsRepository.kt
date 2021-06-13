package com.ephemerayne.data.fakerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.PointsInterpretation
import com.ephemerayne.domain.repository.InterpretationRepository

class FakeInterpretationsRepository : InterpretationRepository {
    val fakeResults = mutableListOf(
        PointsInterpretation(1,0, 9, "Отсутствие депрессивных симптомов", "description"),
        PointsInterpretation(1,10, 15, "Субдепрессия (Легкая депрессия)", "description"),
        PointsInterpretation(1,16, 19, "Умеренная депрессия", "description"),
        PointsInterpretation(1,20, 29, "Выраженная депрессия средней тяжести", "description"),
        PointsInterpretation(1,30, 63, "Тяжелая депрессия", "description"),
    )

    override fun getInterpretation(testId: Int): LiveData<List<PointsInterpretation>> {
        return MutableLiveData<List<PointsInterpretation>>().apply {
            value = fakeResults
        }
    }
}