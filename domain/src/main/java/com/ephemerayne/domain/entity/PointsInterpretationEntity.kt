package com.ephemerayne.domain.entity

data class PointsInterpretationEntity(
    val testId: Int,
    val lowerLimitPoints: Int,
    val upperLimitPoints: Int,
    val result: String,
    val description: String
)