package co.za.kaylen.pillay.valorantagentguide.data.repository.impl

import co.za.kaylen.pillay.valorantagentguide.data.model.DTOAgent
import co.za.kaylen.pillay.valorantagentguide.data.repository.RepositoryAgents
import co.za.kaylen.pillay.valorantagentguide.utils.database.VAGDatabase

class RepositoryAgentsImpl : RepositoryAgents {
    private val agentDAO = VAGDatabase.getAgentDAO()

    override suspend fun getAgents(): List<DTOAgent> {
        return agentDAO.getAgents()
    }
}