package co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylen.pillay.valorantagentguide.domain.usecase.factory.UseCaseFactory
import co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.impl.ViewModelAgentOverviewImpl

class ViewModelAgentOverviewFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAgentOverviewImpl::class.java)) {
            return createViewModelAgentOverviewInstance() as T
        }

        throw IllegalArgumentException("Unable to construct ViewModelAgentOverview")
    }

    private fun createViewModelAgentOverviewInstance(): ViewModelAgentOverviewImpl {
        return ViewModelAgentOverviewImpl(
            useCaseAgentsGet = UseCaseFactory.createUseCaseAgentGet()
        )
    }
}