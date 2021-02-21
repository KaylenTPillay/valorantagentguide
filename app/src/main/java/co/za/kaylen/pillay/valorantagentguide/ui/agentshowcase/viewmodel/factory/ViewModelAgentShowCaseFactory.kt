package co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.impl.ViewModelAgentShowCaseImpl

class ViewModelAgentShowCaseFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelAgentShowCaseImpl::class.java)) {
            return createViewModelAgentShowCaseInstance() as T
        }

        throw IllegalArgumentException("Unable to construct ViewModelAgentShowCase")
    }

    private fun createViewModelAgentShowCaseInstance(): ViewModelAgentShowCaseImpl {
        return ViewModelAgentShowCaseImpl()
    }
}