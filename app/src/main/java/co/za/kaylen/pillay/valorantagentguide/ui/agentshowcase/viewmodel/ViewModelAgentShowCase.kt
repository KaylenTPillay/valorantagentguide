package co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel

import androidx.lifecycle.LiveData
import co.za.kaylen.pillay.valorantagentguide.utils.model.UIModelModeType

interface ViewModelAgentShowCase {

    val agentShowCaseBannerObservable: LiveData<Int>

    fun init(uiMode: UIModelModeType)
}