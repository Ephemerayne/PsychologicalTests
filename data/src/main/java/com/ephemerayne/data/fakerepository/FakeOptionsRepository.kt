package com.ephemerayne.data.fakerepository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ephemerayne.domain.entity.OptionEntity
import com.ephemerayne.domain.repository.OptionsRepository

class FakeOptionsRepository: OptionsRepository {

    override fun getOptions(questionId: Int): LiveData<List<OptionEntity>> {
        return MutableLiveData<List<OptionEntity>>().apply {
            value = listOf(
                OptionEntity(1, 1, 0, "Option 1"),
                OptionEntity(1, 2, 1, "Option 2"),
                OptionEntity(1, 3, 2, "Option 3"),
                OptionEntity(1, 4, 3, "Option 4"),

                OptionEntity(2, 5, 0, "Option 5"),
                OptionEntity(2, 6, 1, "Option 6"),
                OptionEntity(2, 7, 2, "Option 7"),
                OptionEntity(2, 8, 3, "Option 8"),

                OptionEntity(3, 9, 0, "Option 9"),
                OptionEntity(3, 10, 1, "Option 10"),
                OptionEntity(3, 11, 2, "Option 11"),
                OptionEntity(3, 12, 3, "Option 12"),
            ).filter { optionEntity -> optionEntity.questionId == questionId }
        }
    }
}