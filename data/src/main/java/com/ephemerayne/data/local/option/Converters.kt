package com.ephemerayne.data.local.option

import com.ephemerayne.data.local.option.model.OptionModel
import com.ephemerayne.data.response.OptionResponse
import com.ephemerayne.domain.entity.OptionEntity

// ENTITY TO MODEL
fun OptionEntity.entityToModel(): OptionModel = OptionModel(
    questionId = questionId,
    id = id,
    points = points,
    option = option
)

// MODEL TO ENTITY
fun OptionModel.modelToEntity(): OptionEntity = OptionEntity(
    questionId = questionId,
    id = id,
    points = points,
    option = option
)

// RESPONSE TO MODEL
fun OptionResponse.responseToModel(): OptionModel = OptionModel(
    questionId = questionId,
    id = id,
    points = points,
    option = option
)

//MODEL TO RESPONSE
fun OptionModel.modelToResponse(): OptionResponse = OptionResponse(
    questionId = questionId,
    id = id,
    points = points,
    option = option
)

//ENTITIES TO MODELS
fun List<OptionEntity>.entitiesToModels(): List<OptionModel> {
    return map { it.entityToModel() }
}

//MODELS TO ENTITIES
fun List<OptionModel>.modelsToEntities(): List<OptionEntity> {
    return map { it.modelToEntity() }
}

//RESPONSES TO MODELS
fun List<OptionResponse>.responsesToModels(): List<OptionModel> {
    return map { it.responseToModel() }
}

//MODELS TO RESPONSES
fun List<OptionModel>.modelsToResponses(): List<OptionResponse> {
    return map { it.modelToResponse() }
}
