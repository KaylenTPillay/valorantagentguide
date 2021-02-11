package co.za.kaylen.pillay.valorantagentguide.ui.approot.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.domain.usecase.factory.UseCaseFactory
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.transformer.transformUIModel
import co.za.kaylen.pillay.valorantagentguide.ui.approot.viewmodel.ViewModelAppRoot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelAppRootImpl : ViewModelAppRoot, ViewModel() {
    private var isInitialized = false

    private val _agentCollectionLiveData: MutableLiveData<List<UIModelAgentItem>> = MutableLiveData()
    val agentCollectionObservable: LiveData<List<UIModelAgentItem>> = _agentCollectionLiveData

    private val useCaseAgentsGet = UseCaseFactory.createUseCaseAgentGet()

    override fun init() {
        if (!isInitialized) {
            CoroutineScope(Dispatchers.IO).launch {
                _agentCollectionLiveData.postValue(getAgentCollection())
            }
        }
    }

    private suspend fun getAgentCollection(): List<UIModelAgentItem> {
        return useCaseAgentsGet.execute().map { item -> item.transformUIModel() }
    }
}