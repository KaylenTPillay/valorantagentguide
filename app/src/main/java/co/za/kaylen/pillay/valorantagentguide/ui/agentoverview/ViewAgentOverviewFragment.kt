package co.za.kaylen.pillay.valorantagentguide.ui.agentoverview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.kaylen.pillay.valorantagentguide.R
import co.za.kaylen.pillay.valorantagentguide.databinding.AgentOverviewLayoutBinding
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.adapter.AdapterAgentItem
import co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.ViewModelAgentOverview
import co.za.kaylen.pillay.valorantagentguide.ui.agentoverview.viewmodel.factory.ViewModelAgentOverviewFactory
import co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration.ItemDecorationMaxWidth
import co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration.ItemDecorationVerticalSpacing

class ViewAgentOverviewFragment : Fragment() {

    private var binding: AgentOverviewLayoutBinding? = null
    private val viewModel: ViewModelAgentOverview by viewModels {
        ViewModelAgentOverviewFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AgentOverviewLayoutBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeContainer()
        observeViewModel()
    }

    override fun onStart() {
        super.onStart()
        viewModel.init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observeViewModel() {
        viewModel.agentItemObservable.observe(viewLifecycleOwner, { collectionItems ->
            (binding?.agentOverviewContainer?.adapter as? AdapterAgentItem)?.submitList(
                collectionItems
            )
        })
    }

    private fun initializeContainer() {
        binding?.agentOverviewContainer?.adapter = AdapterAgentItem()
        binding?.agentOverviewContainer?.layoutManager = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        if (binding?.agentOverviewContainer?.itemDecorationCount == 0) {
            val dimen16 = resources.getDimensionPixelSize(R.dimen.dimen_16)
            val dimen8 = resources.getDimensionPixelSize(R.dimen.dimen_8)
            val dimen2 = resources.getDimensionPixelSize(R.dimen.dimen_2)

            binding?.agentOverviewContainer?.addItemDecoration(
                ItemDecorationVerticalSpacing(
                    firstItemTopMargin = dimen8,
                    dividerMargin = dimen2,
                    lastItemBottomMargin = dimen16
                )
            )
            binding?.agentOverviewContainer?.addItemDecoration(
                ItemDecorationMaxWidth()
            )
        }
    }
}