package co.za.kaylen.pillay.valorantagentguide.ui.approot

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import co.za.kaylen.pillay.valorantagentguide.R
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.adapter.AdapterAgentItem
import co.za.kaylen.pillay.valorantagentguide.ui.approot.viewmodel.impl.ViewModelAppRootImpl
import co.za.kaylen.pillay.valorantagentguide.databinding.AppRootLayoutBinding
import co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration.ItemDecorationMaxWidth
import co.za.kaylen.pillay.valorantagentguide.utils.itemdecoration.ItemDecorationVerticalSpacing

class AppRootActivity : AppCompatActivity() {
    private lateinit var binding: AppRootLayoutBinding
    private val viewModel by viewModels<ViewModelAppRootImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppRootLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeContainer()
        observeViewModel()
    }

    override fun onStart() {
        super.onStart()
        viewModel.init()
    }

    private fun observeViewModel() {
        viewModel.agentCollectionObservable.observe(this, Observer { collection ->
            (binding.appRootContainer.adapter as? AdapterAgentItem)?.submitList(collection)
        })
    }

    private fun initializeContainer() {
        binding.appRootContainer.adapter =
            AdapterAgentItem()
        binding.appRootContainer.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }

        if (binding.appRootContainer.itemDecorationCount == 0) {
            val dimen16 = resources.getDimensionPixelSize(R.dimen.dimen_16)
            val dimen8 = resources.getDimensionPixelSize(R.dimen.dimen_8)
            val dimen2 = resources.getDimensionPixelSize(R.dimen.dimen_2)

            binding.appRootContainer.addItemDecoration(
                ItemDecorationVerticalSpacing(
                    firstItemTopMargin = dimen8,
                    dividerMargin = dimen2,
                    lastItemBottomMargin = dimen16
                )
            )
            binding.appRootContainer.addItemDecoration(
                ItemDecorationMaxWidth()
            )
        }
    }
}