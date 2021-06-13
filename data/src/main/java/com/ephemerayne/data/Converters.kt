package com.ephemerayne.data

import com.ephemerayne.data.model.CategoryModel
import com.ephemerayne.data.response.CategoryResponse
import com.ephemerayne.domain.entity.CategoryEntity

fun CategoryEntity.entityToModel(): CategoryModel = CategoryModel(
    id = id,
    name = name
)

fun CategoryModel.modelToEntity(): CategoryEntity = CategoryEntity(
    id = id,
    name = name
)

fun CategoryResponse.responseToModel(): CategoryModel = CategoryModel(
    id, name
)

fun CategoryModel.modelToResponse(): CategoryResponse = CategoryResponse(
    id, name
)

fun List<CategoryEntity>.entitiesToModels(): List<CategoryModel> {
    return map { it.entityToModel() }
}

fun List<CategoryModel>.modelsToEntities(): List<CategoryEntity> {
    return map { it.modelToEntity() }
}

fun List<CategoryResponse>.responsesToModels(): List<CategoryModel> {
    return map { it.responseToModel() }
}

fun List<CategoryModel>.modelsToResponses(): List<CategoryResponse> {
    return map { it.modelToResponse() }
}