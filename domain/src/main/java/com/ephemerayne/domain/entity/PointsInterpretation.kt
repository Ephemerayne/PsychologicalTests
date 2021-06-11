package com.ephemerayne.domain.entity

data class PointsInterpretation(
    val lowerLimitPoints: Int,
    val upperLimitPoints: Int,
    val result: String,
    val description: String
)