package co.za.kaylen.pillay.valorantagentguide.agentitem.repository

import co.za.kaylen.pillay.valorantagentguide.agentitem.dbtable.EntityAgent
import co.za.kaylen.pillay.valorantagentguide.utils.database.VAGDatabase

class RepositoryAgents {
    private val agentDAO = VAGDatabase.getAgentDAO()

    suspend fun getAgents(): List<EntityAgent> {
        return agentDAO.getAgents()
    }
}