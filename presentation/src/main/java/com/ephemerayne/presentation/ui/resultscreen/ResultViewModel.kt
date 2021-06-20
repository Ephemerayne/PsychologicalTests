package com.ephemerayne.presentation.ui.resultscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.PointsInterpretationEntity
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.domain.repository.InterpretationRepository
import com.ephemerayne.domain.repository.ResultRepository
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val repository: ResultRepository,
    private val repositoryInterpretation: InterpretationRepository
) : ViewModel() {

    fun getResult(testId: Int): LiveData<List<ResultEntity>> = repository.getResult(testId)

    fun getInterpretation(testId: Int): LiveData<List<PointsInterpretationEntity>> =
        repositoryInterpretation.getInterpretation(testId)
}