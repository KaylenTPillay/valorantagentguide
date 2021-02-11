package co.za.kaylen.pillay.valorantagentguide.ui.agentitem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.viewholder.ViewHolderAgentItem
import co.za.kaylen.pillay.valorantagentguide.ui.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.databinding.AgentItemLayoutBinding

class AdapterAgentItem : RecyclerView.Adapter<ViewHolderAgentItem>() {

    private val differ: AsyncListDiffer<UIModelAgentItem> =
        AsyncListDiffer(this,
            DiffItemCallback()
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAgentItem {
        val binding = AgentItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderAgentItem(
            binding
        )
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: ViewHolderAgentItem, position: Int) {
        val modelForPosition = differ.currentList.getOrNull(position)
        if (modelForPosition != null) {
            holder.onBindViewHolder(modelForPosition)
        }
    }

    fun submitList(list: List<UIModelAgentItem>) {
        differ.submitList(list)
    }

    private class DiffItemCallback : DiffUtil.ItemCallback<UIModelAgentItem>() {

        override fun areItemsTheSame(
            oldItem: UIModelAgentItem,
            newItem: UIModelAgentItem
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: UIModelAgentItem,
            newItem: UIModelAgentItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}