package com.ephemerayne.domain.repository

import androidx.lifecycle.LiveData
import com.ephemerayne.domain.entity.OptionEntity

interface OptionsRepository {

    fun getOptions(questionId: Int): LiveData<List<OptionEntity>>
}