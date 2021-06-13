package com.ephemerayne.data

import com.ephemerayne.data.model.CategoryModel
import com.ephemerayne.domain.entity.CategoryEntity

fun CategoryEntity.toModel(): CategoryModel = CategoryModel(
    id = id,
    name = name
)

fun CategoryModel.toEntity(): CategoryEntity = CategoryEntity(
    id = id,
    name = name
)

fun List<CategoryEntity>.toModelList(): List<CategoryModel> {
    return map { it.toModel() }
}

fun List<CategoryModel>.toEntityList(): List<CategoryEntity> {
    return map { it.toEntity() }
}