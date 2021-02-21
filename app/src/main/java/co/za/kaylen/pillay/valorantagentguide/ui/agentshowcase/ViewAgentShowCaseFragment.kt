package co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import co.za.kaylen.pillay.valorantagentguide.databinding.AgentShowcaseLayoutBinding
import co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.ViewModelAgentShowCase
import co.za.kaylen.pillay.valorantagentguide.ui.agentshowcase.viewmodel.factory.ViewModelAgentShowCaseFactory
import co.za.kaylen.pillay.valorantagentguide.utils.model.UIModelModeType

class ViewAgentShowCaseFragment : Fragment() {
    private var binding: AgentShowcaseLayoutBinding? = null
    private val viewModel: ViewModelAgentShowCase by viewModels {
        ViewModelAgentShowCaseFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AgentShowcaseLayoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    override fun onStart() {
        super.onStart()

        val newConfig = resources.configuration
        val modeType = when (newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> UIModelModeType.DAY_MODE
            Configuration.UI_MODE_NIGHT_YES -> UIModelModeType.NIGHT_MODE
            else -> UIModelModeType.UNKNOWN
        }

        viewModel.init(modeType)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observeViewModel() {
        viewModel.agentShowCaseBannerObservable.observe(viewLifecycleOwner, { backgroundRes ->
            binding?.agentShowcaseAgentBackground?.setImageResource(backgroundRes)
        })
    }
}