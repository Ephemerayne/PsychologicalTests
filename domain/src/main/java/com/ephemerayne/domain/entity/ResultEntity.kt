package com.ephemerayne.domain.entity

import org.threeten.bp.LocalDateTime

data class ResultEntity(
    val id: Int,
    val testId: Int,
    val dateTime: LocalDateTime,
    val points: Int
)