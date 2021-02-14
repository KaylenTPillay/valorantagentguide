package co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.UIModelAgentItem

interface ViewModelAgentOverview {
    val agentItemObservable: LiveData<List<UIModelAgentItem>>

    fun init()
}