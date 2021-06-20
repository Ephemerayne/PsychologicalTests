package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.PointsInterpretationEntity

interface InterpretationRepository {

    fun getInterpretation(testId: Int): LiveData<List<PointsInterpretationEntity>>
}