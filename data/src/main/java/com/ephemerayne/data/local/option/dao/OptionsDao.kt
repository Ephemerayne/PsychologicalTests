package com.ephemerayne.data.local.option.dao

import androidx.lifecycle.LiveData
import com.ephemerayne.data.local.option.model.OptionModel

interface OptionsDao {

    fun insertOption(optionModel: OptionModel)

    fun getOptions(questionId: Int): LiveData<List<OptionModel>>
}