package com.ephemerayne.data.local.category

import com.ephemerayne.data.local.category.model.CategoryModel
import com.ephemerayne.data.response.CategoryResponse
import com.ephemerayne.domain.entity.CategoryEntity

// ENTITY TO MODEL
fun CategoryEntity.entityToModel(): CategoryModel = CategoryModel(
    id = id,
    name = name
)

// MODEL TO ENTITY
fun CategoryModel.modelToEntity(): CategoryEntity = CategoryEntity(
    id = id,
    name = name
)

// RESPONSE TO MODEL
fun CategoryResponse.responseToModel(): CategoryModel = CategoryModel(
    id, name
)

//MODEL TO RESPONSE
fun CategoryModel.modelToResponse(): CategoryResponse = CategoryResponse(
    id, name
)

//ENTITIES TO MODELS
fun List<CategoryEntity>.entitiesToModels(): List<CategoryModel> {
    return map { it.entityToModel() }
}

//MODELS TO ENTITIES
fun List<CategoryModel>.modelsToEntities(): List<CategoryEntity> {
    return map { it.modelToEntity() }
}

//RESPONSES TO MODELS
fun List<CategoryResponse>.responsesToModels(): List<CategoryModel> {
    return map { it.responseToModel() }
}

//MODELS TO RESPONSES
fun List<CategoryModel>.modelsToResponses(): List<CategoryResponse> {
    return map { it.modelToResponse() }
}
