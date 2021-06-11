package com.ephemerayne.presentation.ui.resultscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ephemerayne.domain.entity.ResultEntity
import com.ephemerayne.domain.repository.ResultRepository
import javax.inject.Inject

class ResultViewModel @Inject constructor(
    private val repository: ResultRepository
) : ViewModel() {

    fun getResult(testId: Int): LiveData<List<ResultEntity>> = repository.getResult(testId)
}