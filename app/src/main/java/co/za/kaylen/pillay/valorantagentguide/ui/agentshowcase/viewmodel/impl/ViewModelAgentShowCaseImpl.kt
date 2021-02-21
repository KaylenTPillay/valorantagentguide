package co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.za.kaylen.pillay.valorantagentguide.R
import co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.ViewModelAgentShowCase
import co.za.kaylen.pillay.valorantagentguide.utils.model.UIModelModeType

class ViewModelAgentShowCaseImpl : ViewModel(), ViewModelAgentShowCase {

    private val _agentShowCaseBannerLiveData: MutableLiveData<Int> = MutableLiveData()
    override val agentShowCaseBannerObservable: LiveData<Int> = _agentShowCaseBannerLiveData

    private var currentUIMode: UIModelModeType = UIModelModeType.UNKNOWN

    override fun init(uiMode: UIModelModeType) {
        handleUIModeChange(uiMode)
    }

    private fun handleUIModeChange(uiMode: UIModelModeType) {
        if (uiMode == currentUIMode || uiMode == UIModelModeType.UNKNOWN) return

        val backgroundImageRes = if (uiMode == UIModelModeType.NIGHT_MODE) {
            R.drawable.valorant_agent_showcase_background_black
        } else {
            R.drawable.valorant_agent_showcase_background_red
        }

        _agentShowCaseBannerLiveData.value = backgroundImageRes
    }
}