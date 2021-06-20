package com.ephemerayne.data.local.option.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.ephemerayne.data.local.option.model.OptionModel

class FakeOptionsDao : OptionsDao {
    private val qwe = mutableListOf(
        OptionModel(1, 1, 0, "Fake option Dao 1"),
        OptionModel(1, 2, 1, "Fake option Dao 2"),
        OptionModel(1, 3, 2, "Fake option Dao 3"),
        OptionModel(1, 4, 3, "Fake option Dao 4"),

        OptionModel(2, 5, 0, "Fake option Dao 5"),
        OptionModel(2, 6, 1, "Fake option Dao 6"),
        OptionModel(2, 7, 2, "Fake option Dao 7"),
        OptionModel(2, 8, 3, "Fake option Dao 8"),

        OptionModel(3, 9, 0, "Fake option Dao 9"),
        OptionModel(3, 10, 1, "Fake option Dao 10"),
        OptionModel(3, 11, 2, "Fake option Dao 11"),
        OptionModel(3, 12, 3, "Fake option Dao 12"),
    )

    private val fakeOptionsLiveData = MutableLiveData<List<OptionModel>>().apply {
        value = qwe
    }

    //TODO Не приходит API
    override fun insertOption(optionModel: OptionModel) {
        fakeOptionsLiveData.value = mutableListOf<OptionModel>().apply {
            fakeOptionsLiveData.value?.let { addAll(it) }
//            removeAll { it.id == optionModel.id }
        }
    }

    override fun getOptions(questionId: Int): LiveData<List<OptionModel>> {
        return fakeOptionsLiveData.map { it.filter { it.questionId == questionId } }
    }
}