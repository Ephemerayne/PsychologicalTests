package com.ephemerayne.presentation.ui.resultscreen

import com.ephemerayne.domain.entity.PointsInterpretationEntity


fun getResultDescription(
    points: Int,
    pointsInterpretationEntities: List<PointsInterpretationEntity>
): TestResultInterpretation {
    pointsInterpretationEntities.forEach {
        if (points in it.lowerLimitPoints..it.upperLimitPoints) {
            return TestResultInterpretation(it.result, it.description)
        }
    }
    return TestResultInterpretation(
        "Ошибка в вычислении результата",
        "Ошибка в вычислении результата",
    )
}

data class TestResultInterpretation(
    val result: String,
    val description: String
)
