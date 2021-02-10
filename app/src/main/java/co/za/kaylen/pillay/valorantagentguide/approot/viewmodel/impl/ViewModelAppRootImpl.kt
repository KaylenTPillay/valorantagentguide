package co.za.kaylen.pillay.valorantagentguide.approot.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.valorantagentguide.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.agentitem.repository.RepositoryAgents
import co.za.kaylen.pillay.valorantagentguide.approot.viewmodel.ViewModelAppRoot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelAppRootImpl : ViewModelAppRoot, ViewModel() {
    private var isInitialized = false

    private val _agentCollectionLiveData: MutableLiveData<List<UIModelAgentItem>> = MutableLiveData()
    val agentCollectionObservable: LiveData<List<UIModelAgentItem>> = _agentCollectionLiveData

    override fun init() {
        if (!isInitialized) {
            CoroutineScope(Dispatchers.IO).launch {
                _agentCollectionLiveData.postValue(getAgentCollection())
            }
        }
    }

    private suspend fun getAgentCollection(): List<UIModelAgentItem> {
        val repo = RepositoryAgents()
        return repo.getAgents().map { entity ->
            UIModelAgentItem(
                name = entity.name,
                type = entity.type,
                thumbnailURL = entity.thumbnailURL,
                bodyThumbnailURL = entity.bodyThumbnailURL
            )
        }
    }
}