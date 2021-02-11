package co.za.kaylen.pillay.valorantagentguide.domain.transformer

import co.za.kaylen.pillay.valorantagentguide.data.model.DTOAgent
import co.za.kaylen.pillay.valorantagentguide.domain.model.EntityAgentItem

fun DTOAgent.transformEntity() = EntityAgentItem(
    name = this@transformEntity.name,
    type = this@transformEntity.type,
    thumbnailURL = this@transformEntity.thumbnailURL,
    bodyThumbnailURL = this@transformEntity.bodyThumbnailURL
)