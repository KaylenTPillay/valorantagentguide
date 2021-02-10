package co.za.kaylen.pillay.valorantagentguide.agentitem.viewholder

import androidx.recyclerview.widget.RecyclerView
import co.za.kaylen.pillay.valorantagentguide.agentitem.model.UIModelAgentItem
import co.za.kaylen.pillay.valorantagentguide.databinding.AgentItemLayoutBinding
import co.za.kaylen.pillay.valorantagentguide.utils.load
import co.za.kaylen.pillay.valorantagentguide.utils.setVisibility

class ViewHolderAgentItem(
    private val binding: AgentItemLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBindViewHolder(model: UIModelAgentItem) {
        renderAgentName(model)
        renderAgentType(model)
        renderAgentImage(model)
        renderAgentBody(model)
    }

    private fun renderAgentName(model: UIModelAgentItem) {
        binding.agentItemName.setVisibility(model.isNameActive)
        if (model.isNameActive) {
            binding.agentItemName.text = model.name
        }
    }

    private fun renderAgentType(model: UIModelAgentItem) {
        binding.agentItemType.setVisibility(model.isTypeActive)
        if (model.isTypeActive) {
            binding.agentItemType.text = model.type
        }
    }

    private fun renderAgentImage(model: UIModelAgentItem) {
        binding.agentItemThumbnail.setVisibility(model.isThumbnailActive)
        if (model.isThumbnailActive) {
            binding.agentItemThumbnail.load(
                url = model.thumbnailURL,
                onFailedLoad = {
                    binding.agentItemThumbnail.setVisibility(false)
                }
            )
        }
    }

    private fun renderAgentBody(model: UIModelAgentItem) {
        binding.agentItemBody.setVisibility(model.isBodyThumbnailActive)
        if (model.isBodyThumbnailActive) {
            binding.agentItemBody.load(
                url = model.bodyThumbnailURL,
                onFailedLoad = {
                    binding.agentItemBody.setVisibility(false)
                }
            )
        }
    }
}