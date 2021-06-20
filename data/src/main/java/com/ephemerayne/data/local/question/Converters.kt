package com.ephemerayne.data.local.question

import com.ephemerayne.data.local.question.model.QuestionModel
import com.ephemerayne.data.response.QuestionResponse
import com.ephemerayne.domain.entity.QuestionEntity

// ENTITY TO MODEL
fun QuestionEntity.entityToModel(): QuestionModel = QuestionModel(
    testId = testId,
    id = id,
    title = title
)

// MODEL TO ENTITY
fun QuestionModel.modelToEntity(): QuestionEntity = QuestionEntity(
    testId = testId,
    id = id,
    title = title
)

// RESPONSE TO MODEL
fun QuestionResponse.responseToModel(): QuestionModel = QuestionModel(
    testId = testId,
    id = id,
    title = title
)

//MODEL TO RESPONSE
fun QuestionModel.modelToResponse(): QuestionResponse = QuestionResponse(
    testId = testId,
    id = id,
    title = title
)

//ENTITIES TO MODELS
fun List<QuestionEntity>.entitiesToModels(): List<QuestionModel> {
    return map { it.entityToModel() }
}

//MODELS TO ENTITIES
fun List<QuestionModel>.modelsToEntities(): List<QuestionEntity> {
    return map { it.modelToEntity() }
}

//RESPONSES TO MODELS
fun List<QuestionResponse>.responsesToModels(): List<QuestionModel> {
    return map { it.responseToModel() }
}

//MODELS TO RESPONSES
fun List<QuestionModel>.modelsToResponses(): List<QuestionResponse> {
    return map { it.modelToResponse() }
}
