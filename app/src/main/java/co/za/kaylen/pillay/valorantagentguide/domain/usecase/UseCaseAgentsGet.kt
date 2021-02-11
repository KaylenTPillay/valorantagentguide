package co.za.kaylen.pillay.valorantagentguide.domain.usecase

import co.za.kaylen.pillay.valorantagentguide.data.repository.RepositoryAgents
import co.za.kaylen.pillay.valorantagentguide.domain.model.EntityAgentItem
import co.za.kaylen.pillay.valorantagentguide.domain.transformer.transformEntity

class UseCaseAgentsGet(
    private val repository: RepositoryAgents
) {
    suspend fun execute(): List<EntityAgentItem> {
        return repository.getAgents().map { it.transformEntity() }
    }
}