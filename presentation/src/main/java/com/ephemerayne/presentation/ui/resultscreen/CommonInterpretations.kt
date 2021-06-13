package com.ephemerayne.presentation.ui.resultscreen

import com.ephemerayne.domain.entity.PointsInterpretation


fun getResultDescription(
    points: Int,
    pointsInterpretations: List<PointsInterpretation>
): TestResultInterpretation {
    pointsInterpretations.forEach {
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
