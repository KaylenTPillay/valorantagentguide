package co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.transformer

import co.za.kaylen.pillay.valorantagentguide.domain.model.EntityAgentItem
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.UIModelAgentItem

fun EntityAgentItem.transformUIModel() = UIModelAgentItem(
    name = this@transformUIModel.name,
    type = this@transformUIModel.type,
    thumbnailURL = this@transformUIModel.thumbnailURL,
    bodyThumbnailURL = this@transformUIModel.bodyThumbnailURL
)