package com.ephemerayne.data.local.test

import com.ephemerayne.data.local.test.model.TestModel
import com.ephemerayne.data.response.TestResponse
import com.ephemerayne.domain.entity.TestEntity

// ENTITY TO MODEL
fun TestEntity.entityToModel(): TestModel = TestModel(
    categoryId = categoryId,
    id = id,
    title = title,
    description = description
)

// MODEL TO ENTITY
fun TestModel.modelToEntity(): TestEntity = TestEntity(
    categoryId = categoryId,
    id = id,
    title = title,
    description = description
)

// RESPONSE TO MODEL
fun TestResponse.responseToModel(): TestModel = TestModel(
    categoryId = categoryId,
    id = id,
    title = title,
    description = description
)

//MODEL TO RESPONSE
fun TestModel.modelToResponse(): TestResponse = TestResponse(
    categoryId = categoryId,
    id = id,
    title = title,
    description = description
)

//ENTITIES TO MODELS
fun List<TestEntity>.entitiesToModels(): List<TestModel> {
    return map { it.entityToModel() }
}

//MODELS TO ENTITIES
fun List<TestModel>.modelsToEntities(): List<TestEntity> {
    return map { it.modelToEntity() }
}

//RESPONSES TO MODELS
fun List<TestResponse>.responsesToModels(): List<TestModel> {
    return map { it.responseToModel() }
}

//MODELS TO RESPONSES
fun List<TestModel>.modelsToResponses(): List<TestResponse> {
    return map { it.modelToResponse() }
}