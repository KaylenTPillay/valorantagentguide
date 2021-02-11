package co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model

data class UIModelAgentItem(
    val name: String = String(),
    val type: String = String(),
    val thumbnailURL: String = String(),
    val bodyThumbnailURL: String = String()
) {
    val isNameActive: Boolean
        get() = name.isNotBlank()
    val isTypeActive: Boolean
        get() = type.isNotBlank()
    val isThumbnailActive: Boolean
        get() = thumbnailURL.isNotBlank()
    val isBodyThumbnailActive: Boolean
        get() = bodyThumbnailURL.isNotBlank()
}