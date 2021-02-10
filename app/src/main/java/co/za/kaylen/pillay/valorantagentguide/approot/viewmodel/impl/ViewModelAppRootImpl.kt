package co.za.kaylen.pillay.valorantagentguide.approot.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.valorantagentguide.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.approot.viewmodel.ViewModelAppRoot

class ViewModelAppRootImpl : ViewModelAppRoot, ViewModel() {
    private var isInitialized = false

    private val _agentCollectionLiveData: MutableLiveData<List<UIModelAgentItem>> = MutableLiveData()
    val agentCollectionObservable: LiveData<List<UIModelAgentItem>> = _agentCollectionLiveData

    override fun init() {
        if (!isInitialized) {
            _agentCollectionLiveData.value = getAgentCollection()
        }
    }

    private fun getAgentCollection(): List<UIModelAgentItem> {
        return listOf(
            UIModelAgentItem(
                name = "Jett",
                type = "Duelist",
                thumbnailURL = "https://vgraphs.com/images/agents/jett-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/jett-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Yoru",
                type = "Duelist",
                thumbnailURL = "https://vgraphs.com/images/agents/yoru-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/yoru-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Phoenix",
                type = "Duelist",
                thumbnailURL = "https://vgraphs.com/images/agents/phoenix-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/phoenix-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Raze",
                type = "Duelist",
                thumbnailURL = "https://vgraphs.com/images/agents/raze-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/raze-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Reyna",
                type = "Duelist",
                thumbnailURL = "https://vgraphs.com/images/agents/reyna-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/reyna-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Brimstone",
                type = "Controller",
                thumbnailURL = "https://vgraphs.com/images/agents/brimstone-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/brimstone-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Omen",
                type = "Controller",
                thumbnailURL = "https://vgraphs.com/images/agents/omen-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/omen-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Viper",
                type = "Controller",
                thumbnailURL = "https://vgraphs.com/images/agents/viper-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/viper-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Breach",
                type = "Initiator",
                thumbnailURL = "https://vgraphs.com/images/agents/breach-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/breach-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Skye",
                type = "Initiator",
                thumbnailURL = "https://vgraphs.com/images/agents/skye-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/skye-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Sova",
                type = "Initiator",
                thumbnailURL = "https://vgraphs.com/images/agents/sova-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/sova-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Killjoy",
                type = "Sentinel",
                thumbnailURL = "https://vgraphs.com/images/agents/killjoy-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/killjoy-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Cypher",
                type = "Sentinel",
                thumbnailURL = "https://vgraphs.com/images/agents/cypher-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/cypher-full-portrait.png"
            ),
            UIModelAgentItem(
                name = "Sage",
                type = "Sentinel",
                thumbnailURL = "https://vgraphs.com/images/agents/sage-avatar.jpg",
                bodyThumbnailURL = "https://vgraphs.com/images/agents/300/sage-full-portrait.png"
            )
        )
    }
}