package co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.valorantagentguide.domain.usecase.UseCaseAgentsGet
import co.za.kaylen.pillay.valorantagentguide.domain.usecase.factory.UseCaseFactory
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.transformer.transformUIModel
import co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.ViewModelAgentOverview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelAgentOverviewImpl(
    private val useCaseAgentsGet: UseCaseAgentsGet = UseCaseFactory.createUseCaseAgentGet()
) : ViewModelAgentOverview, ViewModel() {
    private var isInitialized = false

    private val _agentCollectionLiveData: MutableLiveData<List<UIModelAgentItem>> = MutableLiveData()
    override val agentItemObservable: LiveData<List<UIModelAgentItem>> = _agentCollectionLiveData

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